package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    private Coach coach;

    @Autowired
    public API(Coach coach){
        this.coach = coach;
    }

    @GetMapping("/coach")
    public String getCoach(){
        return coach.getDailyWorkout();
    }
}
