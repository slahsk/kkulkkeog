package com.kkulkkeog.payment.service;

import com.kkulkkeog.payment.api.message.OrderPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    


    @Override
    public Mono<Boolean> payment(Mono<OrderPayment> orderPaymentMono) {
//        Payment payment = Payment.factory(order);

        return null;
    }
}
