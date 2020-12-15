package com.raczkowski.springintro.dto;

import com.raczkowski.springintro.entity.User;

public class UserDto {

    private String username;
    private String password;

    public UserDto() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toModel() {
        return new User(username, password);
    }

}
