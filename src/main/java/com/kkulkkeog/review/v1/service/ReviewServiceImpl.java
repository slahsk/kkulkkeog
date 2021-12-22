package com.kkulkkeog.review.v1.service;

import com.kkulkkeog.review.v1.common.exception.ReviewNotFoundException;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;


    @Override
    public Mono<Page<Review>> findAllReviews(Example<Review> example, Pageable pageable) {
        return Mono.just(reviewRepository.findAll(example, pageable));
    }

    @Override
    public Mono<Review> findReview(long reviewNo) {
       return Mono.just(reviewNo)
                .map(reviewRepository::findById)
                .map(review -> review.orElseThrow( () -> new ReviewNotFoundException(reviewNo)));
    }

    @Override
    public Mono<Review> saveReview(Review review) {
        return Mono.just(review)
                .map(reviewRepository::save);
    }

    @Override
    public Mono<Void> deleteReview(long reviewNo) {
       return findReview(reviewNo)
               .doOnNext(review -> review.setDeleted(true))
               .then();
    }
}
