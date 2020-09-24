package com.everysports.user.repository;

import com.everysports.user.domain.ClassList;

import java.util.List;

public interface CustomEClassRepository {

    List<ClassList> findTop5ByOrderByClassNumDescWithClassList();

    List<ClassList> findTop5ByOrderByClassOpenDateDescWithClassList();

    List<ClassList> findByClassCategoryWithClassList(Integer classCategory);

    List<ClassList> findByTeacherIDWithClassList(Long teacherID);

    ClassList findByClassIDWithClassList(Long classID);

}
