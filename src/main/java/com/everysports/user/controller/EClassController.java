package com.everysports.user.controller;

import com.everysports.user.domain.ClassList;
import com.everysports.user.service.EClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EClassController {

    @Autowired
    private EClassService eClassService;

    @GetMapping("/every/hotclass")
    public List<ClassList> hotClass(){
        return eClassService.getHotClass();
    }

}
