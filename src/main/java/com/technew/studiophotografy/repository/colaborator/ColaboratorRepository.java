package com.technew.studiophotografy.repository.colaborator;

import com.technew.studiophotografy.entity.colaborator.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColaboratorRepository extends JpaRepository<Colaborator, UUID> {
}
