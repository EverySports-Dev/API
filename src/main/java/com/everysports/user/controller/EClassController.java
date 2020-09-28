package com.everysports.user.controller;

import com.everysports.user.domain.dto.ClassInfo;
import com.everysports.user.domain.dto.ClassList;
import com.everysports.user.service.EClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EClassController {

    @Autowired
    private EClassService eClassService;

    @GetMapping("/every/hotclass")
    public List<ClassList> getHotClasses(){
        return eClassService.getHotClasses();
    }

    @GetMapping("/every/newclass")
    public List<ClassList> getNewClasses() { return eClassService.getNewClasses(); }

    @GetMapping("/search/class/{classCategory}")
    public List<ClassList> getCategoryClasses(@PathVariable("classCategory") Integer classCategory) {
        return eClassService.getCategoryClasses(classCategory);
    }

    @GetMapping("/classinfo/{classID}")
    public ClassInfo getTeacherInfo(@PathVariable("classID")Long classID){
        return eClassService.getClassInfo(classID);
    }
}
