package com.example.demo.controller;

public class TennisCoach  implements  Coach{

    public TennisCoach(){
        System.out.println("Bean : "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach it is !";
    }
}
