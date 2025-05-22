package com.api.NomNomCounter.config.auth;

import com.api.NomNomCounter.model.UserEntity;
import com.api.NomNomCounter.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private UserRepository userRepository;
    protected  Algorithm algorithm;

    public TokenService (UserRepository userRepository, @Value("{jwt.secret}") String secret){
        algorithm = Algorithm.HMAC256(secret);
        this.userRepository = userRepository;

    }

    public Token createToken(String username){
        var expiretedAt = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));

        String token = JWT.create()
                .withExpiresAt(expiretedAt)
                .withIssuer("NomNomCounter")
                .withSubject(username)
                .sign(algorithm);

        return new Token(token, "JWT");
    }

    public UserEntity getUserFromToken(String token){
        var username = JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();

        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
