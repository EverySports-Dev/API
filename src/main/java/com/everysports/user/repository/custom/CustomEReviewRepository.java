package com.everysports.user.repository.custom;

import com.everysports.user.domain.dto.ReviewList;

import java.util.List;

public interface CustomEReviewRepository {

    List<ReviewList> findByTeacherIDWithReviewList(Long teacherID);

    List<ReviewList> findByClassIDWithReviewList(Long classID);

}
