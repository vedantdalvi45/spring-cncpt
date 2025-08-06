package com.example.demo.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("Bean : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach it is !";
    }
}
