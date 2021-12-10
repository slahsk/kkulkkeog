package com.kkulkkeog.review.v1.domain.mapper;

import com.kkulkkeog.review.v1.api.web.GetReviewRequest;
import com.kkulkkeog.review.v1.api.web.PostReviewRequest;
import com.kkulkkeog.review.v1.api.web.ReviewResponse;
import com.kkulkkeog.review.v1.domain.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toReview(GetReviewRequest getReviewRequest);

    ReviewResponse toReviceResponse(Review review);

    Review toReview(PostReviewRequest postCouponRequest);
}
