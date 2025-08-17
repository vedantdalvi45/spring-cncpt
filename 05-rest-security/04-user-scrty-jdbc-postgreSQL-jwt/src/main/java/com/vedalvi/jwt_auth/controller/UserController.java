package com.vedalvi.jwt_auth.controller;

import com.vedalvi.jwt_auth.entity.RegisterRequest;
import com.vedalvi.jwt_auth.entity.Users;
import com.vedalvi.jwt_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Users registerUser(@RequestBody RegisterRequest request){
        System.out.println(request);
        request.setPassword(encoder.encode(request.getPassword()));
        Users user = userService.registerUser(request);
        System.out.println(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.varify(user);
    }
}
