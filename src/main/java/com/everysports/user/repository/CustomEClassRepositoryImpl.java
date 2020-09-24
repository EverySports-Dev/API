package com.everysports.user.repository;

import com.everysports.user.domain.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

public class CustomEClassRepositoryImpl extends QuerydslRepositorySupport implements CustomEClassRepository {

    public CustomEClassRepositoryImpl(){
        super(EClass.class);
    }

    @Override
    public List<ClassList> findTop5ByOrderByClassNumDesc() {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEClass eClass = QEClass.eClass;
        QEClassAttach eClassAttach = QEClassAttach.eClassAttach;
        QETeacher eTeacher = QETeacher.eTeacher;

        List<ClassList> result = query.selectDistinct(Projections.constructor(ClassList.class,
                eClass.classID, eClass.className, eTeacher.teacherName, eClass.classPrice, eClassAttach.uploadPath
                ,eClassAttach.fileName, eClass.classNum, eClass.classOpenDate)).from(eClass)
                .join(eTeacher).on(eClass.eTeacher.eq(eTeacher))
                .join(eClassAttach).on(eClassAttach.eClass.eq(eClass))
                .where(eClassAttach.mainPhoto.eq(true))
                .limit(5)
                .orderBy(eClass.classNum.desc())
                .fetch();
        return result;
    }

    @Override
    public List<ClassList> findTop5ByOrderByClassOpenDateDesc() {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEClass eClass = QEClass.eClass;
        QEClassAttach eClassAttach = QEClassAttach.eClassAttach;
        QETeacher eTeacher = QETeacher.eTeacher;

        List<ClassList> result = query.selectDistinct(Projections.constructor(ClassList.class,
                eClass.classID, eClass.className, eTeacher.teacherName, eClass.classPrice, eClassAttach.uploadPath
                ,eClassAttach.fileName, eClass.classNum, eClass.classOpenDate)).from(eClass)
                .join(eTeacher).on(eClass.eTeacher.eq(eTeacher))
                .join(eClassAttach).on(eClassAttach.eClass.eq(eClass))
                .where(eClassAttach.mainPhoto.eq(true))
                .limit(5)
                .orderBy(eClass.classOpenDate.desc())
                .fetch();

        return result;
    }

    @Override
    public List<ClassList> findByClassCategory(Integer classCategory) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEClass eClass = QEClass.eClass;
        QEClassAttach eClassAttach = QEClassAttach.eClassAttach;
        QETeacher eTeacher = QETeacher.eTeacher;

        List<ClassList> result = query.selectDistinct(Projections.constructor(ClassList.class,
                eClass.classID, eClass.className, eTeacher.teacherName, eClass.classPrice, eClassAttach.uploadPath
                ,eClassAttach.fileName, eClass.classNum, eClass.classOpenDate)).from(eClass)
                .join(eTeacher).on(eClass.eTeacher.eq(eTeacher))
                .join(eClassAttach).on(eClassAttach.eClass.eq(eClass))
                .where(eClassAttach.mainPhoto.eq(true))
                .where(eClass.classCategory.eq(classCategory))
                .orderBy(eClass.classOpenDate.desc())
                .fetch();

        return result;
    }

    @Override
    public List<ClassList> findByTeacherID(Long teacherID) {

        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEClass eClass = QEClass.eClass;
        QEClassAttach eClassAttach = QEClassAttach.eClassAttach;
        QETeacher eTeacher = QETeacher.eTeacher;

        return query.selectDistinct(Projections.constructor(ClassList.class,
                eClass.classID, eClass.className, eTeacher.teacherName, eClass.classPrice, eClassAttach.uploadPath
                ,eClassAttach.fileName, eClass.classNum, eClass.classOpenDate)).from(eClass)
                .join(eTeacher).on(eClass.eTeacher.eq(eTeacher))
                .join(eClassAttach).on(eClassAttach.eClass.eq(eClass))
                .where(eClassAttach.mainPhoto.eq(true))
                .where(eTeacher.teacherID.eq(teacherID))
                .orderBy(eClass.classOpenDate.desc())
                .limit(5)
                .fetch();
    }
}
