package com.api.NomNomCounter.adaptors.in.persistence.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    
}
