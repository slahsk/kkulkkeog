package com.kkulkkeog.payment.domain;

import com.kkulkkeog.payment.api.message.OrderPayment;
import com.kkulkkeog.payment.domain.Payment;

public class CashPayment implements Payment {

    public CashPayment(OrderPayment orderPayment) {

    }

    @Override
    public boolean payment() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
