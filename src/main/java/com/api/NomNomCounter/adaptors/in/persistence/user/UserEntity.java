package com.api.NomNomCounter.adaptors.in.persistence.user;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String username;
    private String passwordUser;
}
