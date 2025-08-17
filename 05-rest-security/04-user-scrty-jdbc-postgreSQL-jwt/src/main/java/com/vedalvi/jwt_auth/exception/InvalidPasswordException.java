package com.vedalvi.jwt_auth.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String m){
        super(m);
    }
}
