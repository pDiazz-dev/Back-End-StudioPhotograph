package com.technew.studiophotografy.entity.colaborator.studio.schedule.payments;

import com.technew.studiophotografy.entity.colaborator.studio.schedule.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_payment;

    private LocalDateTime date_payment;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private StatusPayment status_payment;

    @Enumerated(EnumType.STRING)
    private TypePayment type_payment;

    @ManyToOne
    @JoinColumn(name = "id_schedule")
    private Schedule schedule;


}
