    package org.example.ebankify.util;

    import io.jsonwebtoken.Jwts;
    import io.jsonwebtoken.SignatureAlgorithm;
    import org.springframework.stereotype.Component;

    import java.util.Date;

    @Component
    public class JwtUtil {

        private final String SECRET_KEY = "=@#&&'''````";

        public String generateToken(String email) {
            return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }

        public boolean validateToken(String token) {

            return true;
        }

        public String extractEmail(String token) {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }
    }
