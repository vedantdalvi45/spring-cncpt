package com.example.demo.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements  Coach{

    public TennisCoach(){
        System.out.println("Bean : "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach it is !";
    }
}
