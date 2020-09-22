package com.everysports.user.controller;

import com.everysports.user.domain.ClassList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EClassController {

    @GetMapping("/every/hotclass")
    public List<ClassList> hotClass(){
        
    }

}
