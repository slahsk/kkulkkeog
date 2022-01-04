package com.kkulkkeog.review.v1.service;

import com.kkulkkeog.review.v1.common.exception.ReviewIllegalArgumentException;
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
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.Optional;

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
                .publishOn(Schedulers.boundedElastic())
                .map(r -> {
                    Optional<Review> data = reviewRepository.findByOrderNoAndUserNo(r.getOrderNo(), r.getUserNo());

                    if( data.isPresent() && Boolean.FALSE.equals(data.get().getDeleted())){
                        throw new ReviewIllegalArgumentException(r.getOrderNo(),  r.getUserNo());
                    }

                   return reviewRepository.save(r);
                });
    }

    @Override
    public Mono<Review> saveReviewComment(long shopNo, long reviewNo, String reviewComment) {
       return findReview(reviewNo)
                .flatMap(review -> {
                    if(shopNo != review.getShopNo()){
                        return Mono.error(new ReviewIllegalArgumentException(shopNo));
                    }

                    review.setReviewComment(reviewComment);
                    review.setReviewCommentTime(LocalDateTime.now());
                    return this.saveReview(review);
                });
    }

    @Override
    public Mono<Void> deleteReview(long reviewNo) {
       return findReview(reviewNo)
               .doOnNext(review -> review.setDeleted(true))
               .then();
    }
}
