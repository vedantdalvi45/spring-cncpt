package com.example.demo.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("Bean : "+getClass().getSimpleName());
    }

    @PostConstruct
    public void initial(){
        System.out.println("PostConstruct of :"+getClass().getSimpleName());
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("PreDestroy of :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach it is !";
    }
}
