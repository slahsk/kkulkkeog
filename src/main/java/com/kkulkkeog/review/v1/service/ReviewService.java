package com.kkulkkeog.review.v1.service;

import com.kkulkkeog.review.v1.domain.Review;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {
    Flux<Review> findAllReviews(Example<Review> example);

    Mono<Review> findReview(long reviewNo);

    Mono<Review> saveReview(Review review);

    Mono<Void> deleteReview(long reviewNo);
}
