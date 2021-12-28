package com.kkulkkeog.coupon.v1.common.exception;

import com.kkulkkeog.coupon.v1.domain.Coupon;

public class CouponNotAvailableException extends CouponException{

    public CouponNotAvailableException(long couponNo) {
        super(String.format("couponNo: %d 사용 불가능 쿠폰 입니다.", couponNo));
    }
}
