package com.technew.studiophotografy.config;

import com.technew.studiophotografy.entity.user.Roles;
import com.technew.studiophotografy.entity.user.TypeRole;
import com.technew.studiophotografy.repository.RolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInisializer  {


    @Bean
    public CommandLineRunner init(RolesRepository rolesRepository) {
        return args -> {
            if (rolesRepository.findByRole(TypeRole.ROLE_ADMIN).isEmpty()) {
                Roles roles = new Roles();
                roles.setRole(TypeRole.ROLE_ADMIN);
                rolesRepository.save(roles);
            }
            if (rolesRepository.findByRole(TypeRole.ROLE_USER).isEmpty()) {
                Roles roles = new Roles();
                roles.setRole(TypeRole.ROLE_USER);
                rolesRepository.save(roles);
            }

        };
    }

}
