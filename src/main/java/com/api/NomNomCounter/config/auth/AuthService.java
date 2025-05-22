package com.api.NomNomCounter.config.auth;

import com.api.NomNomCounter.model.dto.Credentials;
import com.api.NomNomCounter.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    TokenService tokenService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public Token login(Credentials credentials){
        var user = userRepository.findByUsername(credentials.username())
                .orElseThrow(() -> new RuntimeException("Acesso Negado"));

        if(!passwordEncoder.matches(credentials.passwordUser(), user.getPasswordUser())){
            throw new RuntimeException("Acesso negado");
        }

        return tokenService.createToken(credentials.username());
    }
}
