package com.kkulkkeog.coupon.api.message;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CouponValidation {
    private long couponNo;

    private long memberNo;

    private long shopNo;
}
