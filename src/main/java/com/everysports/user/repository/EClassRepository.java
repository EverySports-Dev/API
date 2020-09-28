package com.everysports.user.repository;

import com.everysports.user.domain.EClass;
import com.everysports.user.repository.custom.CustomEClassRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EClassRepository extends JpaRepository<EClass, Long>, CustomEClassRepository {

}
