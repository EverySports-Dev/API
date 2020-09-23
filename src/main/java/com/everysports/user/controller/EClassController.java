package com.everysports.user.controller;

import com.everysports.user.domain.ClassList;
import com.everysports.user.domain.EClass;
import com.everysports.user.service.EClassService;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EClassController {

    @Autowired
    private EClassService eClassService;

    @GetMapping("/every/hotclass")
    public List<ClassList> getHotClass(){
        return eClassService.getHotClass();
    }

    @GetMapping("/every/newclass")
    public List<ClassList> newClass() { return eClassService.getNewClass(); }
}
