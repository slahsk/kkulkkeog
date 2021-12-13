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
    private Long memberNo;

    private Long shopNo;

    private String couponName;

    private String couponDescription;

    private Long minimumPrice;

    private Long discountPrice;

    private CouponIssuer couponIssuer;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
