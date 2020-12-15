package com.raczkowski.springintro.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order not found for given id: " + id);
    }
}
