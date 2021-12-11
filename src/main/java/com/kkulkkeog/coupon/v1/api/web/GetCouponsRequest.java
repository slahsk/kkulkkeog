package com.kkulkkeog.coupon.v1.api.web;

import com.kkulkkeog.coupon.v1.domain.CouponIssuer;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class GetCouponsRequest {
    private long memberNo;

    private long shopNo;

    private String couponName;

    private String couponDescription;

    private long minimumPrice;

    private long discountPrice;

    private CouponIssuer couponIssuer;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
