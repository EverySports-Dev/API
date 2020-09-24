package com.everysports.user.repository;

import com.everysports.user.domain.TeacherList;

import java.util.List;

public interface CustomETeacherRepository {

    List<TeacherList> findByClassCategory(Integer classCategory);

}
