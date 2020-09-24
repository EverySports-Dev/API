package com.everysports.user.controller;

import com.everysports.user.domain.ReviewList;
import com.everysports.user.domain.TeacherInfo;
import com.everysports.user.domain.TeacherList;
import com.everysports.user.service.EReviewService;
import com.everysports.user.service.ETeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ETeacherController {

    @Autowired
    private ETeacherService eTeacherService;
    @Autowired
    private EReviewService eReviewService;

    @GetMapping("/search/teacher/{classCategory}")
    public List<TeacherList> getCategoryTeachers(@PathVariable("classCategory") Integer classCategory){
        return eTeacherService.getCategoryTeachers(classCategory);
    }

    @GetMapping("/teacherinfo/{teacherID}")
    public TeacherInfo getTeacherInfo(@PathVariable("teacherID")Long teacherID){
        return eTeacherService.getTeacherInfo(teacherID);
    }

    @GetMapping("test")
    public List<ReviewList> test(){
        Long test = 1L;
        return eReviewService.test(test);
    }

}
