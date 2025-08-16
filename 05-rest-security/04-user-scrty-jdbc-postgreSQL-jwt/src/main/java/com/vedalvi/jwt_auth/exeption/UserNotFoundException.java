package com.vedalvi.jwt_auth.exeption;

import com.vedalvi.jwt_auth.entity.Users;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
