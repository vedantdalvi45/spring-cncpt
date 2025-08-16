package com.vedalvi.jwt_auth.exeption;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String m){
        super(m);
    }
}
