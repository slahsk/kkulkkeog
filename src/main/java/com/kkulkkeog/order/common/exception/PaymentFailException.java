package com.kkulkkeog.order.common.exception;

public class PaymentFailException extends RuntimeException{
    public PaymentFailException(String message) {
        super(message);
    }
}
