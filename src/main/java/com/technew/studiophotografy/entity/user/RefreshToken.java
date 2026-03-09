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
    private String refreshId;

    private String token;

    private Instant expiresAt;

    @ManyToOne
    private Users users;

}
