package com.vedalvi.jwt_auth.service;

import com.vedalvi.jwt_auth.entity.RegisterRequest;
import com.vedalvi.jwt_auth.entity.Users;
import com.vedalvi.jwt_auth.exception.UserNotFoundException;
import com.vedalvi.jwt_auth.repo.RolesRepo;
import com.vedalvi.jwt_auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationProvider authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users registerUser(RegisterRequest request){
        Users user = Users.builder()
                .id(0)
                .username(request.getUsername())
                .password(request.getPassword())
                .role(rolesRepo.findByRole(request.getRole()))
                .build();
        return userRepo.save(user);
    }

    public String varify(Users user) {
        Users fetchedUser = userRepo.findByUsername(user.getUsername());
        if (fetchedUser == null)
            throw new UserNotFoundException("User "+user.getUsername()+" Not Found");

        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.getJwtToken(user.getUsername());

        return "Unauthorized";

    }
}
