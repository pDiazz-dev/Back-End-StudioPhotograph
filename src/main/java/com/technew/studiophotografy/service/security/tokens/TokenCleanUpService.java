package com.technew.studiophotografy.service.security.tokens;

import com.technew.studiophotografy.repository.user.RefreshTokenRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenCleanUpService {

    private final RefreshTokenRepository refreshTokenRepository;

    public TokenCleanUpService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Scheduled(fixedRate = 86400000) // -> executar sempre a cada 24 horas
    public void deleteExpiresAtToken(){
        refreshTokenRepository.deleteByExpiresAtBefore(Instant.now());
    }

}
