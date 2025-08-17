package com.vedalvi.jwt_auth.exception;

public class CustomExpiredJwtException extends RuntimeException{
    public CustomExpiredJwtException(String m){
        super(m);
    }
}
