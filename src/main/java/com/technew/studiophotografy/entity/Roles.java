package com.technew.studiophotografy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    private String name;


    public enum Ralos{
        CLIENT(2L),
        ADMIN(1L);

        private final Long roleId;
        Ralos(Long roleId) {
            this.roleId = roleId;
        }


        public Long GetRoleId() {
            return this.roleId;
        }
    }


}
