package com.kkulkkeog.order.v1.service;

import com.kkulkkeog.order.v1.domain.Order;

import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<Order> saveOrder(final Order order);

}
