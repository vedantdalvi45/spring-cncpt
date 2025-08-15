package com.vedalvi.jwt_auth.service;

import com.vedalvi.jwt_auth.entity.Users;
import com.vedalvi.jwt_auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationProvider authManager;

    public Users registerUser(Users user){
        return userRepo.save(user);
    }

    public String varify(Users user) {

        if (userRepo.findByUsername(user.getUsername()) == null)
            return "User Not Found !";

        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));


        if (authentication.isAuthenticated())
            return jwtService.getJwtToken(user.getUsername());

        return "Failed TO Log In";
    }
}
