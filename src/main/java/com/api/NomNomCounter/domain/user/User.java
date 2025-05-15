package com.api.NomNomCounter.domain.user;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String passwordUser;

    public User(){}

    public User(UUID id, String username, String passwordUser){
        this.id = id;
        this.username = username;
        this.passwordUser = passwordUser;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    
}