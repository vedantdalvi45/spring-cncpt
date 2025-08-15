package com.vedalvi.jwt_auth.service;

import com.vedalvi.jwt_auth.entity.Users;
import com.vedalvi.jwt_auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public Users registerUser(Users user){
        return userRepo.save(user);
    }

}
