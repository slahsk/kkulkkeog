package com.kkulkkeog.review.v1.domain.mapper;

import com.kkulkkeog.review.v1.api.web.GetReviewRequest;
import com.kkulkkeog.review.v1.api.web.PostReviewRequest;
import com.kkulkkeog.review.v1.api.web.ReviewResponse;
import com.kkulkkeog.review.v1.api.web.ReviewResponse.ReviewResponseBuilder;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.domain.Review.ReviewBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:21:17+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toReview(GetReviewRequest getReviewRequest) {
        if ( getReviewRequest == null ) {
            return null;
        }

        ReviewBuilder review = Review.builder();

        return review.build();
    }

    @Override
    public ReviewResponse toReviceResponse(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewResponseBuilder reviewResponse = ReviewResponse.builder();

        return reviewResponse.build();
    }

    @Override
    public Review toReview(PostReviewRequest postCouponRequest) {
        if ( postCouponRequest == null ) {
            return null;
        }

        ReviewBuilder review = Review.builder();

        return review.build();
    }
}
