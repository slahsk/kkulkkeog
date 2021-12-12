package com.kkulkkeog.coupon.v1.api.web;

import com.kkulkkeog.coupon.v1.domain.CouponIssuer;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class PostCouponRequest {

    @NotNull
    private long shopNo;

    @NotBlank
    private String couponName;

    @NotBlank
    private String couponDescription;

    @NotNull
    private Long minimumOrderPrice;

    @NotNull
    private Long discountPrice;

    @NotNull
    private CouponIssuer couponIssuer;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;
}
