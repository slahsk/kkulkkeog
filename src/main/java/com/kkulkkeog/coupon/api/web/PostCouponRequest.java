package com.kkulkkeog.coupon.api.web;

import com.kkulkkeog.coupon.domain.CouponIssuance;
import com.kkulkkeog.coupon.domain.CouponType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

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
