package com.technew.studiophotografy.entity.colaborator;

import com.technew.studiophotografy.entity.colaborator.studio.Studio;
import com.technew.studiophotografy.entity.user.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class Colaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_colaborator;

    private String document_number;

    @Enumerated(EnumType.STRING)
    private TypeDocument type_document;

    private String number_phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "colaborator")
    private List<Studio> studios;

}
