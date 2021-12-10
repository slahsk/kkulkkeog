package com.kkulkkeog.delivery.v1.service;

import com.kkulkkeog.delivery.v1.domain.Delivery;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DeliveryService {
    Flux<Delivery> findAllDeliveries(Example<Delivery> example);

    Mono<Delivery> findDelivery(long deliveryNo);

    Mono<Delivery> saveDelivery(Delivery delivery);

    Mono<Void> deleteDelivery(long deliveryNo);
}
