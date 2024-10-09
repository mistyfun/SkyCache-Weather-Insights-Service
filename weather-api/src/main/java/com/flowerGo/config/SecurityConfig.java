package com.flowerGo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF for simplicity (optional, but generally required when using a REST API)
        http
                .csrf(csrf -> csrf.disable()) // Use the new API to disable CSRF
                .authorizeRequests()
                .anyRequest().permitAll();  // Allow access to all requests without authentication


        return http.build();
    }
}
