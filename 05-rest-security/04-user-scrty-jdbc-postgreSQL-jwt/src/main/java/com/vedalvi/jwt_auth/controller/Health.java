package com.vedalvi.jwt_auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {
    @GetMapping("/")
    public String health(HttpServletRequest request) {
        return "OK " + request.getSession().getId();
    }
}
