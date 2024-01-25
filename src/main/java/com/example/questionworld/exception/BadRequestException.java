    package com.example.questionworld.exception;

    public class BadRequestException extends RuntimeException {
        public BadRequestException(String erMessage) {
            super(erMessage);
        }
    }
