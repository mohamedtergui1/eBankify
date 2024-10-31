package org.example.ebankify.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ebankify.enums.UserRole;
import org.example.ebankify.exception.NotAuthException;
import org.example.ebankify.exception.PermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter implements Filter {

    private final CustomJwtUtil jwtUtil;

    @Autowired
    public JwtAuthenticationFilter(CustomJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI();
        String authHeader = httpRequest.getHeader("Authorization");

        try {

            if (path.startsWith("/users")) {
                  chechAuth(authHeader);
            } else if (path.startsWith("/employees")) {
                String role = chechAuth(authHeader).split("<@>")[1];
                if (!UserRole.EMPLOYEE.name().equals(role) && !UserRole.ADMIN.name().equals(role)) {
                    throw new PermissionException("You don't have permission for this route");
                }
            }else if(path.startsWith("/admins")){
                String role = chechAuth(authHeader).split("<@>")[1];
                if ( !UserRole.ADMIN.name().equals(role)) {
                    throw new PermissionException("You don't have permission for this route");
                }
            }
            chain.doFilter(request, response);

        } catch (NotAuthException e) {

            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\": \"Authentication required\", \"message\": \"" + e.getMessage() + "\"}");

        } catch (PermissionException e) {

            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\": \"Access Denied\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }


    private String chechAuth(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String email = jwtUtil.extractEmail(token);
            if (!jwtUtil.validateToken(token, email)) {
                throw new NotAuthException("you need to  authenticate");
            }
            if (email.split("<@>").length != 2)
                throw new NotAuthException("invalid token");
            return email;
        } else
            throw new NotAuthException("you need to  authenticate");
    }


    @Override
    public void destroy() {
    }
}