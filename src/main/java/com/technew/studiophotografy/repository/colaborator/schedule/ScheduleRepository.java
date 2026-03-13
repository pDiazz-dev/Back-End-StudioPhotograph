package com.technew.studiophotografy.repository.colaborator.schedule;

import com.technew.studiophotografy.entity.colaborator.studio.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
