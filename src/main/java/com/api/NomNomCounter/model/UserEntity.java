package com.api.NomNomCounter.model;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Users")
@Entity
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String bio;
    @Column(unique = true)
    private String username;
    private String passwordUser;
}
