package com.kkulkkeog.payment.service;

import com.kkulkkeog.order.domain.Order;

public interface PaymentService {
    boolean payment(Order order);
}
