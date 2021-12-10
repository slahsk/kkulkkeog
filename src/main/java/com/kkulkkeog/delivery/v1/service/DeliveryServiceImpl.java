package com.kkulkkeog.delivery.v1.service;

import com.kkulkkeog.delivery.v1.common.exception.DeliveryNotFoundException;
import com.kkulkkeog.delivery.v1.domain.Delivery;
import com.kkulkkeog.delivery.v1.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{
    private final DeliveryRepository deliveryRepository;


    @Override
    public Flux<Delivery> findAllDeliveries(Example<Delivery> example) {
       return Flux.fromIterable(deliveryRepository.findAll(example));
    }

    @Override
    public Mono<Delivery> findDelivery(long deliveryNo) {
        return Mono.just(deliveryRepository.findById(deliveryNo).orElseThrow( () -> new DeliveryNotFoundException(deliveryNo)));
    }

    @Override
    public Mono<Delivery> saveDelivery(Delivery delivery) {

        return Mono.just(deliveryRepository.save(delivery));
    }

    @Override
    public Mono<Void> deleteDelivery(long deliveryNo) {
        Mono<Delivery> review = findDelivery(deliveryNo);

        return  review.doOnNext(r -> r.setDeleted(true))
                .then();
    }
}
