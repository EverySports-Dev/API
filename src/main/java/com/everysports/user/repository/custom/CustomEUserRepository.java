package com.everysports.user.repository.custom;

import com.everysports.user.domain.dto.PaymentList;

import java.util.List;

public interface CustomEUserRepository {


    List<String> findByUserIDWithClassName(Long userID);
}
