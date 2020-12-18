package com.raczkowski.springintro.util;

import com.raczkowski.springintro.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final long JWT_EXPIRATION_MS = 86_400_000;

    private static final String JWT_SECRET = "CodeCoolSecretKey";

    public String generateJwtToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(new Date().toInstant().plusMillis(JWT_EXPIRATION_MS)))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(authToken);

        return true;
    }


}
