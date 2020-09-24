package com.everysports.user.repository;

import com.everysports.user.domain.EReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EReviewRepository extends JpaRepository<EReview, Long>, CustomEReviewRepository {
}
