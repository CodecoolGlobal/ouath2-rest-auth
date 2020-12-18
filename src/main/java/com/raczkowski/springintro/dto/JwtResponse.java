package com.raczkowski.springintro.dto;

public class JwtResponse {

    private long userId;
    private String username;
    private String jwtToken;

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
