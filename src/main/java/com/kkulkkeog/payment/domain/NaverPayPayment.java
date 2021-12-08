package com.kkulkkeog.payment.domain;

import com.kkulkkeog.payment.api.message.OrderPayment;

public class NaverPayPayment implements Payment{

    public NaverPayPayment(OrderPayment orderPayment) {

    }

    @Override
    public boolean payment() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
