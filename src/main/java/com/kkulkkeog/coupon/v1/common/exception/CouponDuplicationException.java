package com.kkulkkeog.coupon.v1.common.exception;

public class CouponDuplicationException extends CouponException{
    public CouponDuplicationException(long couponNo, long userNo) {
        super(String.format("couponNo: %d, userNo: %d 중복 발행할 수 없는 쿠폰 입니다..", couponNo, userNo));
    }
}
