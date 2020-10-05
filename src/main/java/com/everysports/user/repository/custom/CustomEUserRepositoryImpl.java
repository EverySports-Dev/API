package com.everysports.user.repository.custom;

import com.everysports.user.domain.*;
import com.everysports.user.domain.dto.PaymentList;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomEUserRepositoryImpl extends QuerydslRepositorySupport implements CustomEUserRepository {
    public CustomEUserRepositoryImpl() {
        super(EUser.class);
    }


    @Override
    public List<String> findByUserIDWithClassName(Long userID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QEUserClass eUserClass = QEUserClass.eUserClass;
        QEUser eUser = QEUser.eUser;
        QEClass eClass = QEClass.eClass;

        return query.select(eClass.className).from(eClass)
                .join(eUserClass).on(eUserClass.eClass.eq(eClass)).where(eUserClass.eUser.userID.eq(userID))
                .fetch();
    }
}
