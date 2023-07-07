package com.example.lmspeaksoft.exceptions;

public class BadCredentialException extends RuntimeException{

    public BadCredentialException(String message) {
        super(message);
    }
}
