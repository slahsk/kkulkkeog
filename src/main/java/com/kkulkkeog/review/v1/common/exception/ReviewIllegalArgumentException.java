package com.kkulkkeog.review.v1.common.exception;

public class ReviewIllegalArgumentException extends ReviewException{
    public ReviewIllegalArgumentException(long orderNo, long userNo) {
        super(String.format("orderNo: %d, userNo: %d 이미 등록 되어 있는 리뷰 입니다.",orderNo, userNo));
    }

    public ReviewIllegalArgumentException(long shopNo) {
        super(String.format("shopNo: %d 잘못된 정보 입니다.", shopNo));
    }
}
