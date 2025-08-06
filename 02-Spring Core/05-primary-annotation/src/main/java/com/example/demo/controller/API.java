package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class API {
    private Coach coach;

    @Autowired
    public void setCoach(@Qualifier("tennisCoach") Coach theCoach) {
        this.coach = theCoach;
    }

    @GetMapping("/workout")
    public String getCoachName() {
        return this.coach.getDailyWorkout();
    }

}
