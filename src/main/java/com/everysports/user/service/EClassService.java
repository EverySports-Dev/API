package com.everysports.user.service;

import com.everysports.user.domain.dto.ClassInfo;
import com.everysports.user.domain.dto.ClassList;
import com.everysports.user.repository.EClassRepository;
import com.everysports.user.repository.EReviewRepository;
import com.everysports.user.repository.ETeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EClassService {
    @Autowired
    private EClassRepository eClassRepository;
    @Autowired
    private EReviewRepository eReviewRepository;
    @Autowired
    private ETeacherRepository eTeacherRepository;

    public List<ClassList> getHotClasses(){

        return eClassRepository.findTop5ByOrderByClassNumDescWithClassList();
    }

    public List<ClassList> getNewClasses(){

        return eClassRepository.findTop5ByOrderByClassOpenDateDescWithClassList();
    }

    public List<ClassList> getCategoryClasses(Integer classCategory){

        return eClassRepository.findByClassCategoryWithClassList(classCategory);
    }

    public ClassInfo getClassInfo(Long classID){
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassList(eClassRepository.findByClassIDWithClassList(classID));
        classInfo.setReviewList(eReviewRepository.findByClassIDWithReviewList(classID));
        classInfo.setTeacherList(eTeacherRepository.findByClassIDWithTeacherList(classID));
        return classInfo;
    }
}
