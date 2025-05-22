package com.api.NomNomCounter.service;

import com.api.NomNomCounter.model.UserEntity;
import com.api.NomNomCounter.model.dto.UserRequest;
import com.api.NomNomCounter.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(UserEntity userEntity){
        userEntity.setPasswordUser(passwordEncoder.encode(userEntity.getPasswordUser()));
        return userRepository.save(userEntity);
    }
}
