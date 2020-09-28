package com.everysports.user.repository.custom;

import com.everysports.user.domain.*;
import com.everysports.user.domain.dto.ClassList;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomEClassRepositoryImpl extends QuerydslRepositorySupport implements CustomEClassRepository {

    public CustomEClassRepositoryImpl(){
        super(EClass.class);
    }

    @Override
    public List<ClassList> findTop5ByOrderByClassNumDescWithClassList() {

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
    public List<ClassList> findTop5ByOrderByClassOpenDateDescWithClassList() {

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
    public List<ClassList> findByClassCategoryWithClassList(Integer classCategory) {

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
    public List<ClassList> findByTeacherIDWithClassList(Long teacherID) {

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

    @Override
    public ClassList findByClassIDWithClassList(Long classID) {
        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QEClass eClass = QEClass.eClass;
        QEClassAttach eClassAttach = QEClassAttach.eClassAttach;
        QETeacher eTeacher = QETeacher.eTeacher;

        return query.selectDistinct(Projections.constructor(ClassList.class,
                eClass.classID, eClass.className,eClass.classNum,eClass.classPrice, eClassAttach.uploadPath
                ,eClassAttach.fileName, eClass.classPolicy, eClass.classCurriculum)).from(eClass)
                .join(eTeacher).on(eClass.eTeacher.eq(eTeacher))
                .join(eClassAttach).on(eClassAttach.eClass.eq(eClass))
                .where(eClassAttach.mainPhoto.eq(true))
                .where(eClass.classID.eq(classID))
                .orderBy(eClass.classOpenDate.desc())
                .fetchOne();
    }
}
