package com.kkulkkeog.order.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.order.v1.api.web.OrderResponse;
import com.kkulkkeog.order.v1.api.web.PostOrderRequest;
import com.kkulkkeog.order.v1.domain.Order;
import com.kkulkkeog.order.v1.domain.mapper.OrderMapper;
import com.kkulkkeog.order.v1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public Mono<OrderResponse> postOrder(PostOrderRequest postOrderRequest){
        Order order = OrderMapper.INSTANCE.toOrder(postOrderRequest);

        Mono<Order> orderMono = orderService.saveOrder(order);

        return orderMono.map(OrderMapper.INSTANCE::toOrderResponse);
    }

    @DeleteMapping("/orders/{orderNo}")
    public Mono<Void> deleteOrder(@PathVariable Long orderNo){
        return orderService.deleteOrder(orderNo);
    }
}
