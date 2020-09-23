package com.everysports.user.service;

import com.everysports.user.domain.ClassList;
import com.everysports.user.domain.EClass;
import com.everysports.user.domain.EClassAttach;
import com.everysports.user.domain.ETeacher;
import com.everysports.user.repository.EClassRepository;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EClassService {
    @Autowired
    private EClassRepository eClassRepository;

    public List<ClassList> getHotClass(){

        return eClassRepository.findTop5ByOrderByClassNumDesc();
    }

    public List<ClassList> getNewClass(){

        return eClassRepository.findTop5ByOrderByClassOpenDateDesc();
    }
}
