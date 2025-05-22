package com.api.NomNomCounter.model.dto;


import com.api.NomNomCounter.model.UserEntity;

public record UserRequest(
        String username,
        String passwordUser,
        String bio
) {
    public UserEntity toModel(){
        return UserEntity.builder()
                .username(username)
                .passwordUser(passwordUser)
                .bio(bio)
                .build();
    }
}
