package com.kkulkkeog.payment.domain;

import com.kkulkkeog.payment.api.message.OrderPayment;

public class CashPayment implements Payment {

    public CashPayment(OrderPayment orderPayment) {

    }

    @Override
    public boolean payment() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
