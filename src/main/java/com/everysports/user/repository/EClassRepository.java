package com.everysports.user.repository;

import com.everysports.user.domain.EClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EClassRepository extends JpaRepository<EClass, Long>, CustomEClassRepository{

}
