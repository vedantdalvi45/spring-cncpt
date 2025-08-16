package com.vedalvi.jwt_auth;

import com.vedalvi.jwt_auth.entity.Role;
import com.vedalvi.jwt_auth.entity.Users;
import com.vedalvi.jwt_auth.repo.RolesRepo;
import com.vedalvi.jwt_auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JwtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}

    @Autowired
    UserRepo userRepo;
    @Autowired
    RolesRepo rolesRepo;
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args1 -> {

            try {
                Role adminRole = rolesRepo.findByRole("ROLE_ADMIN");

                Users user = new Users();
                user.setUsername("john");
                user.setPassword("secure123");
                user.setRole(adminRole);

                userRepo.save(user);
            } catch (Exception e) {
                System.out.println("Duplicate entry exception: " + e.getMessage());
            }
        };
    }

}
