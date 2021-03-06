package com.kkulkkeog.coupon.v1.api.message;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CouponValidation {
    private long couponNo;

    private long memberNo;

    private long shopNo;
}
