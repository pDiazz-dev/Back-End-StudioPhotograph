package com.technew.studiophotografy.repository;

import com.technew.studiophotografy.entity.user.RefreshToken;
import jakarta.transaction.Transactional;
import org.apache.el.parser.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    @Transactional
    Optional<RefreshToken> findByToken(String token);

    void deleteByExpiresAtBefore(Instant expiresAtBefore);
}
