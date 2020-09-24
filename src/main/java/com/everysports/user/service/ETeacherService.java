package com.everysports.user.service;

import com.everysports.user.domain.TeacherInfo;
import com.everysports.user.domain.TeacherList;
import com.everysports.user.repository.EClassRepository;
import com.everysports.user.repository.EReviewRepository;
import com.everysports.user.repository.ETeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETeacherService {

    @Autowired
    private ETeacherRepository eTeacherRepository;

    @Autowired
    private EClassRepository eClassRepository;

    @Autowired
    private EReviewRepository eReviewRepository;

    public List<TeacherList> getCategoryTeachers(Integer classCategory){

        return eTeacherRepository.findByClassCategoryWithTeacherList(classCategory);
    }

    public TeacherInfo getTeacherInfo(Long teacherID){
        TeacherInfo teacherInfo = eTeacherRepository.findByTeacherIDWithTeacherInfo(teacherID);
        teacherInfo.setClassList(eClassRepository.findByTeacherIDWithClassList(teacherID));
        teacherInfo.setReviewList(eReviewRepository.findByTeacherIDWithReviewList(teacherID));
        return teacherInfo;
    }

}
