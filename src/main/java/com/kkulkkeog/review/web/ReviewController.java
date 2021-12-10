package com.kkulkkeog.review.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.review.api.web.GetReviewRequest;
import com.kkulkkeog.review.api.web.PostReviewRequest;
import com.kkulkkeog.review.api.web.ReviewResponse;
import com.kkulkkeog.review.domain.Review;
import com.kkulkkeog.review.domain.mapper.ReviewMapper;
import com.kkulkkeog.review.service.ReviewService;
import com.kkulkkeog.shop.api.web.GetShopsRequest;
import com.kkulkkeog.shop.api.web.PostShopRequest;
import com.kkulkkeog.shop.api.web.ShopResponse;
import com.kkulkkeog.shop.domain.Shop;
import com.kkulkkeog.shop.domain.mapper.ShopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class ReviewController {
    private final ReviewService reviewService;


    @GetMapping("/reviews")
    public Flux<ReviewResponse> getReviews(GetReviewRequest getReviewRequest){
        Review review = ReviewMapper.INSTANCE.toReview(getReviewRequest);

        Flux<Review> allReview = reviewService.findAllReviews(Example.of(review));


        return allReview.map(ReviewMapper.INSTANCE::toReviceResponse);
    }

    @GetMapping("/reviews/{reviewNo}")
    public Mono<ReviewResponse> getReview(@PathVariable long reviewNo){
        Mono<Review> shop = reviewService.findReview(reviewNo);

        return shop.map(ReviewMapper.INSTANCE::toReviceResponse);
    }

    @PostMapping("/reviews")
    public Mono<ReviewResponse> postReview(PostReviewRequest postCouponRequest){
        Review review = ReviewMapper.INSTANCE.toReview(postCouponRequest);

        Mono<Review> saveReview = reviewService.saveReview(review);

        return saveReview.map(ReviewMapper.INSTANCE::toReviceResponse);
    }

    @DeleteMapping("/reviews/{reviewNo}")
    public Mono<Void> deleteReview(@PathVariable long reviewNo){
        return reviewService.deleteReview(reviewNo);
    }
}
