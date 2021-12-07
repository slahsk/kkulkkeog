package com.kkulkkeog.order.service;

import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.service.CouponService;
import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.menu.service.MenuService;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.order.domain.mapper.OrderMapper;
import com.kkulkkeog.order.repository.OrderRepository;
import com.kkulkkeog.payment.api.message.OrderPayment;
import com.kkulkkeog.payment.service.PaymentService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final MenuService menuService;
    private final CouponService couponService;

    @Override
    public Mono<Order> saveOrder(Order order) {
        List<MenuValidation> menuValidations = OrderMapper.INSTANCE.toMenuValidations(order.getOrderMenus());
        Mono<Boolean> menuValidation = menuService.validation(menuValidations);

        List<CouponValidation> couponValidations = OrderMapper.INSTANCE.toCouponValidations(o.getOrderCoupons());
        Mono<Boolean> couponVlidation = couponService.validation(couponValidations);

//        menuValidation
//                .th
//
//        order.flatMap( o -> {
//            Order data = orderRepository.save(o);
//            OrderPayment orderPayment = OrderMapper.INSTANCE.toOrderPayment(data);
//            paymentService.payment(Mono.just(orderPayment));
//
//        });


        //결재 진행



        return Mono.empty();
    }

    
}
