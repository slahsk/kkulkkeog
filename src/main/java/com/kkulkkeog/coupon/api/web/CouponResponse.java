package com.kkulkkeog.coupon.api.web;

import com.kkulkkeog.coupon.domain.CouponIssuance;
import com.kkulkkeog.coupon.domain.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class CouponResponse {

    private long couponNo;

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

    private boolean availableCoupon;

    private LocalDateTime usedTime;

    private LocalDateTime created;

    private LocalDateTime updated;
}
