package com.everysports.user.repository;

import com.everysports.user.domain.TeacherInfo;
import com.everysports.user.domain.TeacherList;

import java.util.List;

public interface CustomETeacherRepository {

    List<TeacherList> findByClassCategoryWithTeacherList(Integer classCategory);
    TeacherInfo findByTeacherIDWithTeacherInfo(Long teacherID);
    TeacherList findByClassIDWithTeacherList(Long classID);
}
