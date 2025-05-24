package com.api.NomNomCounter.model;

import com.api.NomNomCounter.model.enums.MetaEnum;
import com.api.NomNomCounter.model.enums.NivelDeAtividadeEnum;
import com.api.NomNomCounter.model.enums.SexoEnum;
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
    private Long idUser;
    private String bio;
    private String username;
    private String passwordUser;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
}
