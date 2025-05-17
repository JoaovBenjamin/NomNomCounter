package com.api.NomNomCounter.adaptors.in.controller.user;

import com.api.NomNomCounter.adaptors.in.dto.UserRequest;
import com.api.NomNomCounter.application.core.domain.user.User;
import com.api.NomNomCounter.application.ports.in.InsertUserInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.NomNomCounter.adaptors.out.user.persistence.UserEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("users")
public class UserController {

    private InsertUserInputPort insertUserInputPort;
    public UserController(InsertUserInputPort insertUserInputPort){
        this.insertUserInputPort = insertUserInputPort;
    }

    @PostMapping
    public ResponseEntity user(@RequestBody UserRequest userRequest) throws Exception {
        insertUserInputPort.execute(new User(userRequest.username(), userRequest.passwordUser()));
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
}
