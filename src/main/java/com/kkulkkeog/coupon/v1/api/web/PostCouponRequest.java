package com.kkulkkeog.coupon.v1.api.web;

import java.time.LocalDateTime;

import com.kkulkkeog.coupon.v1.domain.CouponIssuance;
import com.kkulkkeog.coupon.v1.domain.CouponType;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PostCouponRequest {

    private long memberNo;

    private long shopNo;

    private String title;

    private String message;

    private long minimumPrice;

    private long price;

    private CouponIssuance couponIssuance;

    private CouponType couponType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
