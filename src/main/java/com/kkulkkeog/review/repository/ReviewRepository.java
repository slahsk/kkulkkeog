package com.kkulkkeog.review.repository;

import com.kkulkkeog.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
