package com.raczkowski.springintro.util;

import com.raczkowski.springintro.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

import static java.util.Optional.empty;

@Component
public class JwtUtils {

    private static final long JWT_EXPIRATION_MS = 1_800_000;
    private static final String JWT_SECRET = "CodeCoolSecretKey";
    private static final String BEARER_SCHEMA_NAME = "Bearer";

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

    public Optional<String> getTokenFromHeader(String authorizationHeaderValue) {
        if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith(BEARER_SCHEMA_NAME)) {
            return Optional.of(authorizationHeaderValue.substring(7));
        }

        return empty();
    }

    public boolean valid(String authToken) {
        Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(authToken);

        return true;
    }

}
