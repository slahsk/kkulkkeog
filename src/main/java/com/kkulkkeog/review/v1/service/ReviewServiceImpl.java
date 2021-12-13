package com.kkulkkeog.review.v1.service;

import com.kkulkkeog.review.v1.common.exception.ReviewNotFoundException;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;


    @Override
    public Flux<Review> findAllReviews(Example<Review> example) {
        return Flux.fromIterable(reviewRepository.findAll(example));
    }

    @Override
    public Mono<Review> findReview(long reviewNo) {
        return Mono.just(reviewRepository.findById(reviewNo).orElseThrow( () -> new ReviewNotFoundException(reviewNo)));
    }

    @Override
    public Mono<Review> saveReview(Review review) {
        return Mono.just(reviewRepository.save(review));
    }

    @Override
    public Mono<Void> deleteReview(long reviewNo) {
       return findReview(reviewNo)
               .doOnNext(review -> review.setDeleted(true))
               .then();
    }
}
