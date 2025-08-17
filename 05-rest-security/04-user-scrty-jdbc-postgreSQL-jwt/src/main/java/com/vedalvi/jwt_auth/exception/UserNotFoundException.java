package com.vedalvi.jwt_auth.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
