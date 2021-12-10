package com.kkulkkeog.payment.v1.service;

import com.kkulkkeog.payment.v1.api.message.OrderPayment;
import com.kkulkkeog.payment.v1.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    


    @Override
    public Mono<Boolean> payment(OrderPayment orderPayment) {
        Payment payment = Payment.factory(orderPayment);

        return Mono.just(true);
    }
}
