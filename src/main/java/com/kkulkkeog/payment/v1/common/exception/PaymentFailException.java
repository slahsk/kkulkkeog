package com.kkulkkeog.payment.v1.common.exception;

public class PaymentFailException extends RuntimeException{
    public PaymentFailException(String message) {
        super(message);
    }
}
