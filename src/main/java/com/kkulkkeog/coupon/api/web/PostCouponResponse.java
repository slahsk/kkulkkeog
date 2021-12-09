package com.kkulkkeog.coupon.api.web;

import java.time.LocalDateTime;

import com.kkulkkeog.coupon.domain.CouponIssuance;
import com.kkulkkeog.coupon.domain.CouponType;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
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
