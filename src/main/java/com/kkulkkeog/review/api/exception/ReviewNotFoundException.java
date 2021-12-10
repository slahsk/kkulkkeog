package com.kkulkkeog.review.api.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(long reviewNo) {
        super(String.format("%d 리뷰를 찾을 수 없습니다.", reviewNo));
    }
}
