package com.everysports.user.service;

import com.everysports.user.domain.ReviewList;
import com.everysports.user.repository.EReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EReviewService {

    @Autowired
    private EReviewRepository eReviewRepository;

    public List<ReviewList> test(Long test){
        return eReviewRepository.findByTeacherID(test);
    }

}
