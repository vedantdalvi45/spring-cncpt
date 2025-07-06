package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class API {
    private Coach coach;

    private Coach anotherCoach;

    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In Constructor : "+getClass().getSimpleName());
        this.coach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/workout")
    public String getCoachName() {
        return this.coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String heckCoach(){
        return "Comparing Beans (Coach==AnotherCoach) : "+(coach==anotherCoach);
    }

}
