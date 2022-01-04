package com.kkulkkeog.order.v1.service;

import com.kkulkkeog.order.v1.domain.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<Order> findOrder(long orderNo);

    Mono<Order> saveOrder(final Order order);

    Mono<Void> deleteOrder(long orderNo);

    Mono<Page<Order>> findAllOrder(Example<Order> example, Pageable pageable);

}
