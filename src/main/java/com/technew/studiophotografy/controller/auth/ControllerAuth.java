package com.technew.studiophotografy.controller.auth;

import com.technew.studiophotografy.entity.user.DTOs.AuthUserDTO;
import com.technew.studiophotografy.entity.user.DTOs.RegisterDTO;
import com.technew.studiophotografy.service.security.AuthService;
import com.technew.studiophotografy.service.security.DTOs.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ControllerAuth {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthUserDTO authUserDTO) {
        return authService.login(authUserDTO);

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO) {
        authService.register(registerDTO);
        return ResponseEntity.ok().build();
    }

}
