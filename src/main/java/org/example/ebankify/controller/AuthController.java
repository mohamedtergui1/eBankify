package org.example.ebankify.controller;

import jakarta.validation.Valid;
import org.example.ebankify.request.LoginRequest;
import org.example.ebankify.request.RegisterRequest;
import org.example.ebankify.entity.User;
import org.example.ebankify.service.auth.AuthService;
import org.example.ebankify.util.CustomJwtUtil;
import org.example.ebankify.util.ResponseForme;
import org.example.ebankify.util.ResponseFormeWithToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final CustomJwtUtil jwtUtil;
    @Autowired
    public AuthController(AuthService authService, CustomJwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseForme<ResponseFormeWithToken<User>>> login(@RequestBody @Valid LoginRequest loginRequest) {
        User user = authService.login(loginRequest);
        return ResponseEntity.ok(new ResponseFormeWithToken<User>(jwtUtil.generateToken(user.getEmail() + "<@>" + user.getRole().name()), user, "login with success"));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseForme<User>> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseEntity.status(201).body(new ResponseForme<User>(authService.register(registerRequest.toUser()), "register with success"));
    }

}