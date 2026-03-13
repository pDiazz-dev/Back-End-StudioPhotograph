package com.technew.studiophotografy.entity.colaborator.studio;

import com.technew.studiophotografy.entity.colaborator.Colaborator;
import com.technew.studiophotografy.entity.colaborator.studio.schedule.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_studio;

    private String city;

    private String address;

    @OneToMany(mappedBy = "studio")
    private List<Schedule> schedules;


    @ManyToOne
    @JoinColumn(name = "id_colaborator")
    private Colaborator colaborator;


}
