package com.api.NomNomCounter.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {    
    @Bean    
    SecurityFilterChain config(HttpSecurity http, AuthFilter authFilter) throws Exception{
         http.csrf( csrf -> csrf.disable());
         http.authorizeHttpRequests(
           auth -> auth
                   .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                   .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                   .anyRequest().authenticated()

         );

         http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
         return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}