package com.vedant.crud_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfigure {
    private final String ADMIN = "ADMIN";
    private final String MANAGER = "MANAGER";
    private final String EMPLOYEE = "EMPLOYEE";

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager(dataSource);
        detailsManager.setUsersByUsernameQuery(
                "SELECT user_id , pw , active FROM members WHERE user_id = ?"
        );

        detailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id , role FROM roles WHERE user_id = ?"
        );
        return detailsManager;
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
