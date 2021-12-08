package com.kkulkkeog.payment.api.exception;

public class PaymentFailException extends RuntimeException{
    public PaymentFailException(String message) {
        super(message);
    }
}
