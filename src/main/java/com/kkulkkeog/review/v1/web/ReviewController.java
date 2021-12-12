package com.kkulkkeog.review.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.review.v1.api.web.GetReviewRequest;
import com.kkulkkeog.review.v1.api.web.PostReviewRequest;
import com.kkulkkeog.review.v1.api.web.ReviewResponse;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.domain.mapper.ReviewMapper;
import com.kkulkkeog.review.v1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class ReviewController {
    private final ReviewService reviewService;


    @GetMapping("/reviews")
    public Flux<ReviewResponse> getReviews(GetReviewRequest getReviewRequest){
        Review review = ReviewMapper.INSTANCE.toReview(getReviewRequest);

        Flux<Review> allReview = reviewService.findAllReviews(Example.of(review));


        return allReview.map(ReviewMapper.INSTANCE::toReviewResponse);
    }

    @GetMapping("/reviews/{reviewNo}")
    public Mono<ReviewResponse> getReview(@PathVariable Long reviewNo){
        Mono<Review> review = reviewService.findReview(reviewNo);

        return review.map(ReviewMapper.INSTANCE::toReviewResponse);
    }

    @PostMapping("/reviews")
    public Mono<ReviewResponse> postReview(PostReviewRequest postCouponRequest){
        Review review = ReviewMapper.INSTANCE.toReview(postCouponRequest);

        Mono<Review> saveReview = reviewService.saveReview(review);

        return saveReview.map(ReviewMapper.INSTANCE::toReviewResponse);
    }

    @DeleteMapping("/reviews/{reviewNo}")
    public Mono<Void> deleteReview(@PathVariable long reviewNo){
        return reviewService.deleteReview(reviewNo);
    }
}
