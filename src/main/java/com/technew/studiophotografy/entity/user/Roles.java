package com.technew.studiophotografy.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false ,unique = true)
    private TypeRole role;



}
