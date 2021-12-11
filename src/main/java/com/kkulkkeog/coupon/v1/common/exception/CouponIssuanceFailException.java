package com.kkulkkeog.coupon.v1.common.exception;

public class CouponIssuanceFailException extends RuntimeException{
    public CouponIssuanceFailException(long couponNo, long userNo) {
        super(String.format("couponNo: %d, userNo: %d 쿠폰 발행 실패 했습니다.", couponNo, userNo));
    }
}
