package com.kkulkkeog.review.domain.mapper;

import com.kkulkkeog.review.api.web.GetReviewRequest;
import com.kkulkkeog.review.api.web.PostReviewRequest;
import com.kkulkkeog.review.api.web.ReviewResponse;
import com.kkulkkeog.review.domain.Review;
import com.kkulkkeog.shop.api.web.ShopResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toReview(GetReviewRequest getReviewRequest);

    ReviewResponse toReviceResponse(Review review);

    Review toReview(PostReviewRequest postCouponRequest);
}
