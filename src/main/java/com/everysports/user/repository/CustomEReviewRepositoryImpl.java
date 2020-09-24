package com.everysports.user.repository;

import com.everysports.user.domain.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomEReviewRepositoryImpl extends QuerydslRepositorySupport implements CustomEReviewRepository {

    public CustomEReviewRepositoryImpl() {
        super(EReview.class);
    }


    @Override
    public List<ReviewList> findByTeacherID(Long teacherID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEReview eReview = QEReview.eReview;
        QEUserClass eUserClass = QEUserClass.eUserClass;
        QETeacher eTeacher = QETeacher.eTeacher;

        List<ReviewList> result = query.select(Projections.constructor(ReviewList.class,eUserClass.eUser.userID,eReview.reviewTitle,
                                                                        eReview.reviewContent, eReview.reviewCreatedAt))
                                        .from(eReview).join(eUserClass).on(eReview.eUserClass.eq(eUserClass))
                                        .where(eUserClass.eClass.eTeacher.teacherID.eq(teacherID)).limit(5).fetch();

        return result;
    }
}
