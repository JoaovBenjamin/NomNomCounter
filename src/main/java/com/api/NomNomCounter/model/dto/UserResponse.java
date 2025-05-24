package com.api.NomNomCounter.model.dto;

import com.api.NomNomCounter.model.UserEntity;
import com.api.NomNomCounter.model.enums.SexoEnum;

public record UserResponse(
        String username,
        String bio,
        SexoEnum sexo
) {
    public static UserResponse fromModel(UserEntity userEntity){
        return new UserResponse(
            userEntity.getUsername(),
            userEntity.getBio(),
            userEntity.getSexo()
        );
    }
}
