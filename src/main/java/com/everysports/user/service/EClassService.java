package com.everysports.user.service;

import com.everysports.user.domain.ClassList;
import com.everysports.user.repository.EClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EClassService {
    @Autowired
    private EClassRepository eClassRepository;

    public List<ClassList> getHotClass(){
        return eClassRepository.findTop5ByOrderByClassNumDesc();
    }
}
