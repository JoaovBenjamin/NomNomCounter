package com.api.NomNomCounter.infrastructure.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    public SecurityFilterChain config(HttpSecurity http) throws Exception{
        http.csrf(csfr -> csfr.disable());
        return http.build();
    }
}
