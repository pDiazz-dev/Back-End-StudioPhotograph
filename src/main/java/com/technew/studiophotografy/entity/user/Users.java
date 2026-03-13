package com.technew.studiophotografy.entity.user;

import com.technew.studiophotografy.entity.colaborator.Colaborator;
import com.technew.studiophotografy.entity.colaborator.studio.schedule.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
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


    @OneToMany(mappedBy = "users")
    private List<Schedule> schedule;

    @ManyToMany(fetch = FetchType.LAZY)
    //tabela relacionada N to N, nova tabela chamada 'tb_user_roles'
    @JoinTable(
            name = "tb_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Roles> roles =  new HashSet<>();

    @OneToMany(mappedBy = "user_id")
    private List<RefreshToken> refreshToken;

    @OneToOne(mappedBy = "users")
    private Colaborator colaborator;

}
