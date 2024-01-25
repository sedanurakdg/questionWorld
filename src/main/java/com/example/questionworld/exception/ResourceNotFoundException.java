package com.example.questionworld.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String erMessage) {
        super(erMessage);
    }
}
