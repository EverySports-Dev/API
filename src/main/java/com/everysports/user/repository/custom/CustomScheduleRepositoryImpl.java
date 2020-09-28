package com.everysports.user.repository.custom;

import com.everysports.user.domain.*;
import com.everysports.user.domain.dto.UserScheduleList;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
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

    @Override
    public List<UserScheduleList> findByUserIDWithUserScheduleList(Long userID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
        QETeacher eTeacher = QETeacher.eTeacher;
        QEClassSchedule eClassSchedule = QEClassSchedule.eClassSchedule;
        QEClass eClass = QEClass.eClass;
        return query.select(Projections.constructor(UserScheduleList.class,eTeacher.teacherName, eClass.className, eClassSchedule))
                                            .from(eClassSchedule).join(eTeacher).on(eTeacher.eq(eClassSchedule.eUserClass.eClass.eTeacher))
                                            .join(eClass).on(eClass.eq(eClassSchedule.eUserClass.eClass)).fetch();

    }
}
