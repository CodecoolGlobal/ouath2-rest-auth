package com.raczkowski.springintro.dto;

public class JwtResponse {
    private final long userId;
    private final String username;
    private final String jwtToken;

    public JwtResponse(long userId, String username, String jwtToken) {
        this.userId = userId;
        this.username = username;
        this.jwtToken = jwtToken;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
