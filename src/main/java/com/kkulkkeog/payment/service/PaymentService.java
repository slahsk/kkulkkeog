package com.kkulkkeog.payment.service;

import com.kkulkkeog.payment.api.message.OrderPayment;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<Boolean> payment(Mono<OrderPayment> orderPaymentMono);
}
