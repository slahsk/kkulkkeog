package com.kkulkkeog.coupon.v1.common.exception;

public class CouponIssuanceFailException extends CouponException{
    public CouponIssuanceFailException(long couponNo, long userNo) {
        super(String.format("couponNo: %d, userNo: %d 발행할 수 없는 쿠폰 입니다..", couponNo, userNo));
    }
}
