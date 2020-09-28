package com.everysports.user.repository;

import com.everysports.user.domain.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomScheduleRepositoryImpl extends QuerydslRepositorySupport implements CustomScheduleRepository {
    public CustomScheduleRepositoryImpl() {
        super(EClassSchedule.class);
    }

    @Override
    public String findByClassIDAndUserID(Long classID, Long userID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QEClassSchedule eClassSchedule = QEClassSchedule.eClassSchedule;
        QEUserClass eUserClass = QEUserClass.eUserClass;

        return query.select(eClassSchedule.day).from(eClassSchedule).join(eUserClass).on(eUserClass.eq(eClassSchedule.eUserClass))
                                .where(eUserClass.eUser.userID.eq(userID))
                                .where(eUserClass.eClass.classID.eq(classID)).fetchOne();
    }

    @Override
    public List<String> findByClassID(Long classID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QEClassSchedule eClassSchedule = QEClassSchedule.eClassSchedule;
        QEUserClass eUserClass = QEUserClass.eUserClass;

        return query.select(eClassSchedule.day).from(eClassSchedule).join(eUserClass).on(eUserClass.eq(eClassSchedule.eUserClass))
                                    .where(eUserClass.eClass.classID.eq(classID)).fetch();
    }

    @Override
    public String findByTeacherID(Long teacherID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QETeacherSchedule eTeacherSchedule = QETeacherSchedule.eTeacherSchedule;

        return query.select(eTeacherSchedule.day).from(eTeacherSchedule).where(eTeacherSchedule.eTeacher.teacherID.eq(teacherID)).fetchOne();
    }
}
