package com.eureka.cooperfilme.utils;

public class BadRequestError extends RuntimeException{
    public BadRequestError(String message) {
        super(message);
    }
}