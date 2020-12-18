package com.raczkowski.springintro.controller;

import com.raczkowski.springintro.dto.CredentialsDto;
import com.raczkowski.springintro.dto.JwtResponse;
import com.raczkowski.springintro.dto.UserDto;
import com.raczkowski.springintro.entity.User;
import com.raczkowski.springintro.service.UserService;
import com.raczkowski.springintro.util.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("/api/auth")
public class AuthController {

    private final UserService userService;

    private final JwtUtils jwtUtils;

    public AuthController(UserService userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public void register(@RequestBody UserDto userDto) {
        userService.register(userDto);
    }

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public JwtResponse login(@RequestBody CredentialsDto credentialsDto) {
        Authentication authentication = userService.login(credentialsDto);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return toJwtResponse(authentication);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public ResponseEntity<String> handleException(BadCredentialsException badCredentialsException) {
        return new ResponseEntity<>(badCredentialsException.getMessage(), UNAUTHORIZED);
    }

    private JwtResponse toJwtResponse(Authentication authentication) {
        String jwtToken = jwtUtils.generateJwtToken(authentication);
        User user = (User) authentication.getPrincipal();

        return new JwtResponse(user.getId(),
                user.getUsername(),
                jwtToken);
    }

}
