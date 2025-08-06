package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class API {
    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/coach-name")
    private String returnCoachName(){
        return coachName;
    }
}
