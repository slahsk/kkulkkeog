package com.kkulkkeog.review.v1.repository;

import com.kkulkkeog.review.v1.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByOrderNoAndUserNo(long orderNo, long userNo);
}
