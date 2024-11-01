package org.example.ebankify.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

public interface Jwt {

    public String generateToken(String email);

    public boolean validateToken(String token, String email);

    public String extractEmail(String token);

    public Claims extractClaims(String token);

}
