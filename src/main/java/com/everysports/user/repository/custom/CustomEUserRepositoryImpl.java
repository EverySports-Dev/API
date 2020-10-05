package com.everysports.user.repository.custom;

import com.everysports.user.domain.*;
import com.everysports.user.domain.dto.PaymentList;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CustomEUserRepositoryImpl extends QuerydslRepositorySupport implements CustomEUserRepository {
    public CustomEUserRepositoryImpl() {
        super(EUser.class);
    }


}
