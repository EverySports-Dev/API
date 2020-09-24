package com.everysports.user.repository;

import com.everysports.user.domain.CategoryList;
import com.everysports.user.domain.ClassList;
import com.everysports.user.domain.EClass;
import com.everysports.user.domain.ReviewList;
import com.querydsl.core.Tuple;

import java.util.List;

public interface CustomEClassRepository {

    List<ClassList> findTop5ByOrderByClassNumDesc();

    List<ClassList> findTop5ByOrderByClassOpenDateDesc();

    List<ClassList> findByClassCategory(Integer classCategory);

    List<ClassList> findByTeacherID(Long teacherID);

}
