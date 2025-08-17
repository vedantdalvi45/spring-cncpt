package com.vedalvi.jwt_auth.exception;

public class CustomSignatureException extends RuntimeException{
    public CustomSignatureException(String m){
        super(m);
    }
}
