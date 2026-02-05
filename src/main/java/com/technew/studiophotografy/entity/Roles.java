package com.technew.studiophotografy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    private String name;

}
