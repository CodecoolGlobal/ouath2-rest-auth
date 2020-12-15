package com.raczkowski.springintro.controller;

import com.raczkowski.springintro.dto.CredentialsDto;
import com.raczkowski.springintro.dto.UserDto;
import com.raczkowski.springintro.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public void register(@RequestBody UserDto userDto) {
        userService.registerNewUser();
    }

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    public void login(@RequestBody CredentialsDto credentialsDto) {
        userService.login();
    }


}
