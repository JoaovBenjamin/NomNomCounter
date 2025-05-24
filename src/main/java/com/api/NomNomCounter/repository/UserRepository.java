package com.api.NomNomCounter.repository;

import java.util.Optional;

import com.api.NomNomCounter.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long >{

    Optional<UserEntity> findByUsername(String username);
}
