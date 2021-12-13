package com.kkulkkeog.delivery.v1.service;

import com.kkulkkeog.delivery.v1.domain.Delivery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface DeliveryService {
    Mono<Page<Delivery>> findAllDeliveries(Example<Delivery> example, Pageable pageable);

    Mono<Delivery> findDelivery(long deliveryNo);

    Mono<Delivery> saveDelivery(Delivery delivery);

    Mono<Void> deleteDelivery(long deliveryNo);
}
