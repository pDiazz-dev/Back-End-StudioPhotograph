package com.technew.studiophotografy.service.security;


import com.technew.studiophotografy.entity.user.Users;
import com.technew.studiophotografy.service.security.DTOs.LoginResponse;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.stream.Collectors;


@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;

    public TokenService( JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public LoginResponse tokenGenerate(Users user){

        String scopes = user.getRoles()
                .stream()
                .map(roles ->  roles.getRole().name())
                .collect(Collectors.joining(" "));

        var EXPIRES_IN = 300L;
        var NOW = Instant.now();

        var claims = JwtClaimsSet.builder()
                .issuer("my backend")
                .subject(String.valueOf(user.getUserEmail()))
                .issuedAt(NOW)
                .expiresAt(NOW.plusSeconds(EXPIRES_IN))
                .claim("authorities", scopes)
                .build();
        String tokenValue= jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(tokenValue,EXPIRES_IN);

    }

}
