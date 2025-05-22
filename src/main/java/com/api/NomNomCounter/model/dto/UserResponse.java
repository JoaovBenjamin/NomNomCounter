package com.api.NomNomCounter.model.dto;

import com.api.NomNomCounter.model.UserEntity;

public record UserResponse(
        String username,
        String bio
) {
    public static UserResponse fromModel(UserEntity userEntity){
        return new UserResponse(
            userEntity.getUsername(),
            userEntity.getBio()
        );
    }
}
