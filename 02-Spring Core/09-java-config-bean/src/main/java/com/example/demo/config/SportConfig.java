package com.example.demo.config;

import com.example.demo.controller.Coach;
import com.example.demo.controller.TennisCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("tennisC")
    public Coach tennisCoach(){
        return new TennisCoach();
    }
}
