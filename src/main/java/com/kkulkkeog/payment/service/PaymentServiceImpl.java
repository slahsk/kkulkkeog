package com.kkulkkeog.payment.service;

import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.payment.domain.Payment;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    
    
    @Override
    public boolean payment(Order order) {
        Payment payment = Payment.factory(order);


        return true;
    }
    
}
