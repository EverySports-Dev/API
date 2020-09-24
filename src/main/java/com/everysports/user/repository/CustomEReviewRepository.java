package com.everysports.user.repository;

import com.everysports.user.domain.ReviewList;

import java.util.List;

public interface CustomEReviewRepository {

    List<ReviewList> findByTeacherIDWithReviewList(Long teacherID);

    List<ReviewList> findByClassIDWithReviewList(Long classID);

}
