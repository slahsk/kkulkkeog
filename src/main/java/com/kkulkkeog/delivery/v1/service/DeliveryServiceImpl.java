package com.kkulkkeog.delivery.v1.service;

import com.kkulkkeog.delivery.v1.common.exception.DeliveryNotFoundException;
import com.kkulkkeog.delivery.v1.domain.Delivery;
import com.kkulkkeog.delivery.v1.api.DeliveryState;
import com.kkulkkeog.delivery.v1.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService{
    private final DeliveryRepository deliveryRepository;


    @Override
    public Mono<Page<Delivery>> findAllDeliveries(Example<Delivery> example, Pageable pageable) {
       return Mono.just(deliveryRepository.findAll(example,pageable));
    }

    @Override
    public Mono<Delivery> findDelivery(long deliveryNo) {
        return Mono.just(deliveryNo)
                .map(deliveryRepository::findById)
                .map( delivery -> delivery.orElseThrow( () -> new DeliveryNotFoundException(deliveryNo)));

    }

    @Override
    public Mono<Delivery> saveDelivery(Delivery delivery) {
        return Mono.just(delivery)
                .map(deliveryRepository::save);
    }

    @Override
    public Mono<Delivery> updateDeliveryState(long deliveryNo, DeliveryState deliveryState) {
        return findDelivery(deliveryNo)
                .map(delivery -> {
                    log.debug("updateDeliveryState - deliveryNo: {}, state: {} -> {}", delivery.getDeliveryNo(),delivery.getDeliveryState(), deliveryState);
                    delivery.setDeliveryState(deliveryState);
                    return delivery;
                });
    }

    @Override
    public Mono<Void> deleteDelivery(long deliveryNo) {
        return Mono.just(deliveryNo)
                .flatMap(this::findDelivery)
                .doOnNext(r -> r.setDeleted(true))
                .then();
    }
}
