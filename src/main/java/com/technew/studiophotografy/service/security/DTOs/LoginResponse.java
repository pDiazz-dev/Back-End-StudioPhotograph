package com.technew.studiophotografy.service.security.DTOs;

public record LoginResponse(String acessToken, Long expiresIn) {
}
