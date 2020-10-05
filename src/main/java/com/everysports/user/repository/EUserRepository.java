package com.everysports.user.repository;

import com.everysports.user.domain.EUser;
import com.everysports.user.repository.custom.CustomEUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EUserRepository extends JpaRepository<EUser, Long>, CustomEUserRepository {
    EUser findByUserID(Long user_ID);
}
