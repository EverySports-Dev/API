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

        return eTeacherRepository.findByClassCategory(classCategory);
    }

    public TeacherInfo getTeacherInfo(Long teacherID){
        TeacherInfo teacherInfo = eTeacherRepository.findByTeacherID(teacherID);
        teacherInfo.setClassLists(eClassRepository.findByTeacherID(teacherID));
        teacherInfo.setReviewLists(eReviewRepository.findByTeacherID(teacherID));
        return teacherInfo;
    }

}
