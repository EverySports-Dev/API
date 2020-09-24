package com.everysports.user.repository;

import com.everysports.user.domain.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;

public class CustomETeacherRepositoryImpl extends QuerydslRepositorySupport implements CustomETeacherRepository  {

    public CustomETeacherRepositoryImpl() {
        super(ETeacher.class);
    }

    @Override
    public List<TeacherList> findByClassCategory(Integer classCategory) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QETeacher eTeacher = QETeacher.eTeacher;
        QEClass eClass = QEClass.eClass;
        QEProfile eProfile = QEProfile.eProfile;

        List<TeacherList> result = query.select(Projections.constructor(TeacherList.class, eTeacher.teacherID,
                                        eTeacher.teacherName,
                                        eProfile.uploadPath, eProfile.fileName)).from(eTeacher)
                                        .join(eClass).on(eClass.eTeacher.teacherID.eq(eTeacher.teacherID))
                                        .join(eProfile).on(eProfile.allID.eq(eTeacher.teacherID))
                                        .where(eClass.classCategory.eq(classCategory))
                                        .distinct()
                                        .fetch();

        for (TeacherList item:result) {
            item.setClassSumNum(query.select(count(eClass)).from(eClass).where(eClass.eTeacher.teacherID.eq(item.getTeacherID())).fetchOne());
        }

        return result;
    }

    @Override
    public TeacherInfo findByTeacherID(Long teacherID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QETeacher eTeacher = QETeacher.eTeacher;
        QEClass eClass = QEClass.eClass;
        QEProfile eProfile = QEProfile.eProfile;

        return query.select(Projections.constructor(TeacherInfo.class,
                eTeacher.teacherName, eTeacher.teacherEmail, eTeacher.teacherGender, eProfile.uploadPath, count(eClass.eTeacher),
                eProfile.uploadPath, eProfile.fileName)).from(eTeacher).join(eProfile).on(eProfile.allID.eq(eTeacher.teacherID)).join(eClass).on(eClass.eTeacher.eq(eTeacher)).fetchOne();
    }
}
