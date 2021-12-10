package com.kkulkkeog.review.service;

import com.kkulkkeog.review.api.exception.ReviewNotFoundException;
import com.kkulkkeog.review.domain.Review;
import com.kkulkkeog.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
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
        Mono<Review> review = findReview(reviewNo);

        return  review.doOnNext(r -> r.setDeleted(true))
                .then();
    }
}
