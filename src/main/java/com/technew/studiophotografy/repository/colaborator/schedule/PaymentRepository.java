package com.technew.studiophotografy.repository.colaborator.schedule;

import com.technew.studiophotografy.entity.colaborator.studio.schedule.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Long> {
}
