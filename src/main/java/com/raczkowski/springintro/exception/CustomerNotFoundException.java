package com.raczkowski.springintro.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("User not found for given id: " + id);
    }
}
