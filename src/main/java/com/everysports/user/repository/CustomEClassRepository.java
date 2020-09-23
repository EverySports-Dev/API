package com.everysports.user.repository;

import com.everysports.user.domain.ClassList;
import com.everysports.user.domain.EClass;
import com.querydsl.core.Tuple;

import java.util.List;

public interface CustomEClassRepository {

    List<ClassList> findTop5ByOrderByClassNumDesc();

}
