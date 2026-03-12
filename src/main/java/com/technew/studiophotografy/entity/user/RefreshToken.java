package com.technew.studiophotografy.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_refresh_token")
@Getter
@Setter
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long refreshId;

    @Column(columnDefinition = "TEXT")
    private String token;

    private Instant expiresAt;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;

}
