package com.technew.studiophotografy.repository;

import com.technew.studiophotografy.entity.user.Roles;
import com.technew.studiophotografy.entity.user.TypeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRole(TypeRole role);
}
