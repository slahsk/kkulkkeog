package com.kkulkkeog.coupon.v1.api.web;

import java.time.LocalDateTime;

import com.kkulkkeog.coupon.v1.domain.CouponIssuer;
import com.kkulkkeog.coupon.v1.domain.CouponType;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PutCouponRequest {
    private String title;

    private String message;

    private long maxPrice;

    private int percent;

    private int price;

    private CouponIssuer couponIssuer;

    private CouponType couponType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
