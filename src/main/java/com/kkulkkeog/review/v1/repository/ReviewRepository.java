package com.kkulkkeog.review.v1.repository;

import com.kkulkkeog.review.v1.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
