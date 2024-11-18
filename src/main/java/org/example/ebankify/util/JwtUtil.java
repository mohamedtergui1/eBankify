package org.example.ebankify.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil implements Jwt {

    private final String SECRET_KEY = "jfzbieu  ç7891JKDHIUAZHDIUE8237YR3H2IDX298HDIUP3HD92738DH13ç7891JKDHIUAZHDIUE8237YR3H2IDX298HDIUP3HD92738DH13ç7891JKDHIUAZHDIUE8237YR3H2IDX298HDIUP3HD92738DH13ç7891JKDHIUAZHDIUE8237YR3H2IDX298HDIUP3HD92738DH13";
    private final long EXPIRATION_TIME = 86400000;

    public String generateToken(String InputString) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(InputString)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512);

        return jwtBuilder.compact();
    }


    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes();
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());
    }


    public boolean validateToken(String token, String InputString) {
        final String extractedInputString = extractInputString(token);
        return (extractedInputString.equals(InputString) && !isTokenExpired(token));
    }


    public String extractInputString(String token) {
        return extractClaims(token).getSubject();
    }

    @Override
    public String extractEmailString(String token) {
        return extractInputString(token).split("<@>")[0];
    }




    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
