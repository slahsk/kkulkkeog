package com.kkulkkeog.coupon.api.web;

import java.time.LocalDateTime;

import com.kkulkkeog.coupon.domain.CouponIssuance;
import com.kkulkkeog.coupon.domain.CouponType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostCouponRequest {
    private String title;

    private String message;

    private long maxPrice;

    private int percent;

    private int price;

    private CouponIssuance couponIssuance;

    private CouponType couponType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
