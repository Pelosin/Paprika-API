package com.paprika.api.exception;

public class InvalidCredentialsException extends IllegalArgumentException{
    public InvalidCredentialsException(String s) {
        super(s);
    }
}
