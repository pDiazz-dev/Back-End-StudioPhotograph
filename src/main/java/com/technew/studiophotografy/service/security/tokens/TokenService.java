package com.technew.studiophotografy.service.security.tokens;


import com.technew.studiophotografy.entity.user.RefreshToken;
import com.technew.studiophotografy.entity.user.Users;
import com.technew.studiophotografy.repository.RefreshTokenRepository;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;


import java.time.Instant;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class TokenService {

    // CONSTS
    private static final Long REFRESH_TOKEN_EXPIRES = 86400L; // 1 dia -> 24h
    private static final Long ACCESS_TOKEN_EXPIRES = 300L; // 5 MIN


    // CONTRUTORES
    private final JwtEncoder jwtEncoder;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenService(JwtEncoder jwtEncoder, RefreshTokenRepository refreshTokenRepository) {
        this.jwtEncoder = jwtEncoder;
        this.refreshTokenRepository = refreshTokenRepository;
    }



    // GERAÇÃO DE TOKEN PADRONIZADA
    private String generateToken(Users user, Map<String, Object> claims, Long expires) {

        Instant now = Instant.now();

        JwtClaimsSet.Builder builder = JwtClaimsSet.builder()
                .issuer("my-backend")
                .subject(user.getUserEmail())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expires));

        if (claims != null) {
            claims.forEach(builder::claim);
        }

        JwtClaimsSet jwtClaims = builder.build();

        return jwtEncoder
                .encode(JwtEncoderParameters.from(jwtClaims))
                .getTokenValue();
    }

    // GERAÇÃO DE ACESS TOKEN
    public String generateAccessToken(Users user) {

        // LISTAR TODAS AS ROLES DO USUARIO PARA APARECER NO CLAIM
        String authorities = user.getRoles()
                .stream()
                .map(role -> role.getRole().name())
                .collect(Collectors.joining(" "));

        Map<String, Object> claims;
        claims = Map.of(
                "authorites", authorities
        );

        return generateToken( user, claims,ACCESS_TOKEN_EXPIRES);
    }

    // GERAÇÃO DE REFRESH TOKEN
    public String generateRefreshToken(Users user){


        Map<String, Object> claims; // -> claims para diferenciar o tipo do token
        claims = Map.of(
                "token_type", "refresh"
        );

        Instant expiresAt = Instant.now().plusSeconds(REFRESH_TOKEN_EXPIRES); // salvo como instant para prencheer o db

        String tokenRefresh = generateToken(user,claims , REFRESH_TOKEN_EXPIRES);

        // criação refresh token para por no db
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setExpiresAt(expiresAt);
        refreshToken.setToken(tokenRefresh);


        refreshTokenRepository.save(refreshToken);

        return tokenRefresh;
    }

}
