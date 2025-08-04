package com.vedant.crud_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfigure {
    private final String ADMIN = "ADMIN";
    private final String MANAGER = "MANAGER";
    private final String EMPLOYEE = "EMPLOYEE";

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles(EMPLOYEE)
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles(MANAGER,EMPLOYEE)
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles(ADMIN,MANAGER,EMPLOYEE)
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET,"api/employees").hasRole(EMPLOYEE)
                    .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole(EMPLOYEE)
                    .requestMatchers(HttpMethod.POST,"api/employees").hasRole(MANAGER)
                    .requestMatchers(HttpMethod.POST,"api/employees/all").hasRole(MANAGER)
                    .requestMatchers(HttpMethod.PUT,"api/employees").hasRole(MANAGER)
                    .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole(ADMIN)
                    .requestMatchers(HttpMethod.PATCH,"api/employees/**").hasRole(MANAGER)
        );
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
