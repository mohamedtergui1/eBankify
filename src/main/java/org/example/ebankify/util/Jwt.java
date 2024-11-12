package org.example.ebankify.util;

import io.jsonwebtoken.Claims;


public interface Jwt {

    public String generateToken(String email);

    public boolean validateToken(String token, String email);

    public String extractInputString(String token);

    public Claims extractClaims(String token);

}
