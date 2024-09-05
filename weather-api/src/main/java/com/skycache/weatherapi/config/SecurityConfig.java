package com.skycache.weatherapi.config;

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
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // Allow unauthenticated access to /api/**
                        .anyRequest().authenticated()            // Require authentication for all other requests
                );

        return http.build();
    }
}
