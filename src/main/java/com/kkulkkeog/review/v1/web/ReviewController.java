package com.kkulkkeog.review.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.review.v1.api.web.GetReviewRequest;
import com.kkulkkeog.review.v1.api.web.PostReviewRequest;
import com.kkulkkeog.review.v1.api.web.PutReviewCommentRequest;
import com.kkulkkeog.review.v1.api.web.ReviewResponse;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.domain.mapper.ReviewMapper;
import com.kkulkkeog.review.v1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class ReviewController {
    private final ReviewService reviewService;


    @GetMapping("/reviews")
    public Mono<Page<ReviewResponse>> getReviews(GetReviewRequest getReviewRequest, Pageable pageable){
        Review review = ReviewMapper.INSTANCE.toReview(getReviewRequest);

        Mono<Page<Review>> reviewPage = reviewService.findAllReviews(Example.of(review), pageable);

        return reviewPage.map(r -> r.map(ReviewMapper.INSTANCE::toReviewResponse));
    }

    @GetMapping("/reviews/{reviewNo}")
    public Mono<ReviewResponse> getReview(@PathVariable Long reviewNo){
        Mono<Review> review = reviewService.findReview(reviewNo);

        return review.map(ReviewMapper.INSTANCE::toReviewResponse);
    }

    @PostMapping("/reviews")
    public Mono<ReviewResponse> postReview(@RequestBody PostReviewRequest postCouponRequest){
        Review review = ReviewMapper.INSTANCE.toReview(postCouponRequest);

        Mono<Review> saveReview = reviewService.saveReview(review);

        return saveReview.map(ReviewMapper.INSTANCE::toReviewResponse);
    }

    @PutMapping("/reviews/{reviewNo}/comment")
    public Mono<ReviewResponse> putReviewComment(@PathVariable Long reviewNo,@RequestBody PutReviewCommentRequest request){

        //TODO JWT를 통해서 로그인한 shopNo 가져오기
        Mono<Review> saveReview = reviewService.saveReviewComment(0,reviewNo,request.getReviewComment());

        return saveReview.map(ReviewMapper.INSTANCE::toReviewResponse);
    }

    @DeleteMapping("/reviews/{reviewNo}")
    public Mono<Void> deleteReview(@PathVariable long reviewNo){
        return reviewService.deleteReview(reviewNo);
    }
}
