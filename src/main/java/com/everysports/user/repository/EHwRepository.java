package com.everysports.user.repository;

import com.everysports.user.domain.EHw;
import com.everysports.user.repository.custom.CustomEHwRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EHwRepository extends JpaRepository<EHw, Long>, CustomEHwRepository {
}
