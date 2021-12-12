package com.kkulkkeog.order.v1.common.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(long orderNo) {
        super(String.format("%d 주문을 찾을 수 없습니다.", orderNo));
    }
}
