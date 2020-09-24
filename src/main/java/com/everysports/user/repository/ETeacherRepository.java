package com.everysports.user.repository;

import com.everysports.user.domain.ETeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ETeacherRepository extends JpaRepository<ETeacher, Long>, CustomETeacherRepository {
}
