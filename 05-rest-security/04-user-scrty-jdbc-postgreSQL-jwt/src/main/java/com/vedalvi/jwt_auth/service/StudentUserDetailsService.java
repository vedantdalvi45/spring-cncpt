package com.vedalvi.jwt_auth.service;

import com.vedalvi.jwt_auth.entity.UserPrincipal;
import com.vedalvi.jwt_auth.entity.Users;
import com.vedalvi.jwt_auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username){
        Users user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.printf("user not found !");
            throw new UsernameNotFoundException("User Not Found !");
        }

        return new UserPrincipal(user);
    }
}
