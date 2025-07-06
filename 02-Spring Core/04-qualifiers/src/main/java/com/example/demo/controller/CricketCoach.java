package com.example.demo.controller;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Cricket Coach it is !";
    }
}
