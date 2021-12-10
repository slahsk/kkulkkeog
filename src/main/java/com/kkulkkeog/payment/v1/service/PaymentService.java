package com.kkulkkeog.payment.v1.service;

import com.kkulkkeog.payment.v1.api.message.OrderPayment;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<Boolean> payment(OrderPayment orderPayment);
}
