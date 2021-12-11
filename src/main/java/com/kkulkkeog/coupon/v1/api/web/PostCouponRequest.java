package com.kkulkkeog.coupon.v1.api.web;

import java.time.LocalDateTime;

import com.kkulkkeog.coupon.v1.domain.CouponIssuer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PostCouponRequest {

    private long memberNo;

    private long shopNo;

    private String couponName;

    private String couponDescription;

    private long minimumOrderPrice;

    private long discountPrice;

    private CouponIssuer couponIssuer;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
