package com.everysports.user.repository;

import com.everysports.user.domain.EClassSchedule;
import com.everysports.user.repository.custom.CustomScheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<EClassSchedule, Long>, CustomScheduleRepository {
}
