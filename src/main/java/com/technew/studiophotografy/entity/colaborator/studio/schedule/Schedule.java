package com.technew.studiophotografy.entity.colaborator.studio.schedule;

import com.technew.studiophotografy.entity.colaborator.studio.Studio;
import com.technew.studiophotografy.entity.colaborator.studio.schedule.payments.Payment;
import com.technew.studiophotografy.entity.user.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_schedule;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users client;

    private LocalDateTime start_date;
    private LocalDateTime end_date;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private StatusSchedule status_schedule;

    @OneToMany(mappedBy = "schedule")
    private List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "id_studio")
    private Studio studio;



}
