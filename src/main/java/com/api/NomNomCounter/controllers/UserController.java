package com.api.NomNomCounter.controllers;

import com.api.NomNomCounter.config.auth.AuthService;
import com.api.NomNomCounter.model.dto.Credentials;
import com.api.NomNomCounter.config.auth.Token;
import com.api.NomNomCounter.model.dto.UserRequest;
import com.api.NomNomCounter.model.dto.UserResponse;
import com.api.NomNomCounter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("user")
public class UserController {


    AuthService authService;
    private UserService userService;

    public UserController(UserService userService, AuthService authService) {

        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder uriComponentsBuilder){
       var user = userService.createUser(userRequest.toModel());
       var uri = uriComponentsBuilder
               .path("user/{id}")
               .buildAndExpand(user.getIdUser())
               .toUri();

        return ResponseEntity.created(uri).body(UserResponse.fromModel(user));
    }

    @PostMapping("login")
    public Token login(@RequestBody Credentials credentials){
        return authService.login(credentials);
    }
}
