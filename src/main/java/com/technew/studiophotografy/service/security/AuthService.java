package com.technew.studiophotografy.service.security;

import com.technew.studiophotografy.entity.user.DTOs.AuthUserDTO;
import com.technew.studiophotografy.entity.user.DTOs.RegisterDTO;
import com.technew.studiophotografy.entity.user.TypeRole;
import com.technew.studiophotografy.entity.user.Users;
import com.technew.studiophotografy.repository.RolesRepository;
import com.technew.studiophotografy.repository.UserRepository;
import com.technew.studiophotografy.service.security.DTOs.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final TokenService tokenService;
    public AuthService(UserRepository userRepository, RolesRepository rolesRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.tokenService = tokenService;
    }


    public ResponseEntity<LoginResponse> login(AuthUserDTO authUserDTO){
        var user =userRepository.findByUserEmail(authUserDTO.userEmail())
                .orElseThrow(()-> new RuntimeException("User or password not found"));

        var usernamePassword= new UsernamePasswordAuthenticationToken(authUserDTO.userEmail(), authUserDTO.userPassword());
        this.authenticationManager.authenticate(usernamePassword);

        LoginResponse response = tokenService.tokenGenerate(user);

        return ResponseEntity.ok(response);
    }


    public ResponseEntity register(RegisterDTO registerDTO){
        if(userRepository.findByUserEmail(registerDTO.userEmail()).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new  BCryptPasswordEncoder().encode(registerDTO.userPassword());

        var role = rolesRepository.findByRole(TypeRole.ROLE_USER).orElseThrow(()-> new RuntimeException("Role not found"));
        var user = new Users();
        user.setUsername(registerDTO.userName());
        user.setUserEmail(registerDTO.userEmail());
        user.setUserPassword(encryptedPassword);
        user.getRoles().add(role);

        userRepository.save(user);
        return ResponseEntity.ok().build();

    }





}
