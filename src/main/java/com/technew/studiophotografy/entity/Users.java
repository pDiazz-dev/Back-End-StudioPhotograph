package com.technew.studiophotografy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userName;
    @Column(unique = true)
    private String userEmail;

    private String userPassword;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    //tabela relacionada N to N, nova tabela chamada 'tb_user_roles'
    @JoinTable(
            name = "tb_user_roles",
            joinColumns = @JoinColumn(name = "tb_users"),
            inverseJoinColumns = @JoinColumn(name = "tb_roles")
    )
    private Set<Roles> roles;
}
