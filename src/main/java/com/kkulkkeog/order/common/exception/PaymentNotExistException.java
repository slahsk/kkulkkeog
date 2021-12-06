package com.kkulkkeog.order.common.exception;


public class PaymentNotExistException extends RuntimeException{

    public PaymentNotExistException(long orderNo){
        super(String.format("orderNo: %d", orderNo));
    }

    
}