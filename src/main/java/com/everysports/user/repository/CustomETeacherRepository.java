package com.everysports.user.repository;

import com.everysports.user.domain.dto.TeacherInfo;
import com.everysports.user.domain.dto.TeacherList;

import java.util.List;

public interface CustomETeacherRepository {

    List<TeacherList> findByClassCategoryWithTeacherList(Integer classCategory);
    TeacherInfo findByTeacherIDWithTeacherInfo(Long teacherID);
    TeacherList findByClassIDWithTeacherList(Long classID);
}
