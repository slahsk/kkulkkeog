package com.kkulkkeog.delivery.v1.common.exception;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException(long reviewNo) {
        super(String.format("%d 주문을 찾을 수 없습니다.", reviewNo));
    }
}
