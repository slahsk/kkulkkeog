package com.kkulkkeog.order.service;

import com.kkulkkeog.order.domain.Order;

import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<Order> saveOrder(final Order order);

}
