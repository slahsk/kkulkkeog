package com.kkulkkeog.order.service;

import com.kkulkkeog.menu.service.MenuService;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.order.repository.OrderRepository;
import com.kkulkkeog.payment.domain.Payment;
import com.kkulkkeog.payment.service.PaymentService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final MenuService menuService;

    @Override
    public Mono<Order> saveOrder(Order order) {
        //메뉴 검사(가격, 주문한 메뉴 체크)
        menuService.validation();

        //쿠폰 검사(유효성 체크)


        Order data = orderRepository.save(order);

        //결재 진행
        paymentService.payment(data);
        


        return Mono.just(data);
    }

    
}
