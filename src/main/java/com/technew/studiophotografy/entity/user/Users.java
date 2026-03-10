package com.technew.studiophotografy.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column
    private String username;

    @Column(nullable = false,unique = true)
    private String userEmail;

    private String userPassword;


    @ManyToMany(fetch = FetchType.LAZY)
    //tabela relacionada N to N, nova tabela chamada 'tb_user_roles'
    @JoinTable(
            name = "tb_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Roles> roles =  new HashSet<>();

    @OneToMany
    private RefreshToken refreshToken;

}
