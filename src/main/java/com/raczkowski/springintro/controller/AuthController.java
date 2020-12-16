package com.raczkowski.springintro.controller;

import com.raczkowski.springintro.dto.CredentialsDto;
import com.raczkowski.springintro.dto.UserDto;
import com.raczkowski.springintro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
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
        userService.registerNewUser(userDto);
    }

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public void login(@RequestBody CredentialsDto credentialsDto) {
        userService.login(credentialsDto);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public ResponseEntity<String> handleException(BadCredentialsException badCredentialsException) {
        return new ResponseEntity<>(badCredentialsException.getMessage(), UNAUTHORIZED);
    }

}
