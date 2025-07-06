package com.example.demo.controller;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach it is !";
    }
}
