package com.kkulkkeog.review.v1.service;

import com.kkulkkeog.review.v1.domain.Review;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface ReviewService {
    Mono<Page<Review>> findAllReviews(Example<Review> example, Pageable pageable);

    Mono<Review> findReview(long reviewNo);

    Mono<Review> saveReview(Review review);

    Mono<Void> deleteReview(long reviewNo);
}
