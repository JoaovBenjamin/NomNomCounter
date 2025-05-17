package com.api.NomNomCounter.adaptors.out.user.persistence;

import java.util.UUID;

import com.api.NomNomCounter.adaptors.out.user.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
