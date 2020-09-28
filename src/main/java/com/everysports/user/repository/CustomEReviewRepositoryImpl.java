package com.everysports.user.repository;

import com.everysports.user.domain.*;
import com.everysports.user.domain.dto.ReviewList;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomEReviewRepositoryImpl extends QuerydslRepositorySupport implements CustomEReviewRepository {

    public CustomEReviewRepositoryImpl() {
        super(EReview.class);
    }


    @Override
    public List<ReviewList> findByTeacherIDWithReviewList(Long teacherID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEReview eReview = QEReview.eReview;
        QEUserClass eUserClass = QEUserClass.eUserClass;

        return query.select(Projections.constructor(ReviewList.class,eUserClass.eUser.userID,eReview.reviewTitle,
                                                                        eReview.reviewContent, eReview.reviewCreatedAt))
                                        .from(eReview).join(eUserClass).on(eReview.eUserClass.eq(eUserClass))
                                        .where(eUserClass.eClass.eTeacher.teacherID.eq(teacherID)).limit(5).fetch();
    }

    @Override
    public List<ReviewList> findByClassIDWithReviewList(Long classID) {
        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEReview eReview = QEReview.eReview;
        QEUserClass eUserClass = QEUserClass.eUserClass;

        return query.select(Projections.constructor(ReviewList.class,eUserClass.eUser.userID,eReview.reviewTitle,
                eReview.reviewContent, eReview.reviewCreatedAt))
                .from(eReview).join(eUserClass).on(eReview.eUserClass.eq(eUserClass))
                .where(eUserClass.eClass.classID.eq(classID)).fetch();
    }
}
