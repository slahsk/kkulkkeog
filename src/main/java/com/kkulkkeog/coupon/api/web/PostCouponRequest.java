package com.kkulkkeog.coupon.api.web;

import java.time.LocalDateTime;

import com.kkulkkeog.coupon.domain.CouponIssuance;
import com.kkulkkeog.coupon.domain.CouponType;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
