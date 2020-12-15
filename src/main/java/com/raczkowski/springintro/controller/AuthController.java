package com.raczkowski.springintro.controller;

import com.raczkowski.springintro.dto.CredentialsDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class AuthController {

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    public String login(@RequestBody CredentialsDto credentialsDto) {
        return "dupa";
    }



}
