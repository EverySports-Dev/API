package com.everysports.user.service;

import com.everysports.user.domain.TeacherList;
import com.everysports.user.repository.ETeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETeacherService {

    @Autowired
    private ETeacherRepository eTeacherRepository;

    public List<TeacherList> getCategoryTeachers(Integer classCategory){

        return eTeacherRepository.findByClassCategory(classCategory);
    }

}
