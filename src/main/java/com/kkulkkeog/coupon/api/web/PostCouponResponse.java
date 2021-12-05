package com.kkulkkeog.coupon.api.web;

import com.kkulkkeog.coupon.domain.CouponIssuance;
import com.kkulkkeog.coupon.domain.CouponType;

import java.time.LocalDateTime;

public class PostCouponResponse {
    private Long no;

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
