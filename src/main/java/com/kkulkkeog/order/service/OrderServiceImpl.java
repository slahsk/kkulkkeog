package com.kkulkkeog.order.service;

import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.service.CouponService;
import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.menu.service.MenuService;
import com.kkulkkeog.order.common.exception.CouponValidationException;
import com.kkulkkeog.order.common.exception.MenuValidationException;
import com.kkulkkeog.order.common.exception.PaymentFailException;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.order.domain.OrderState;
import com.kkulkkeog.order.domain.mapper.OrderMapper;
import com.kkulkkeog.order.repository.OrderRepository;
import com.kkulkkeog.payment.api.message.OrderPayment;
import com.kkulkkeog.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final MenuService menuService;
    private final CouponService couponService;

    @Override
    public Mono<Order> saveOrder(Order order) {

        Order data = orderRepository.save(order);

        List<MenuValidation> menuValidations = OrderMapper.INSTANCE.toMenuValidations(order.getOrderMenus());

       return  menuService.orderValidation(menuValidations)
        .flatMap( b -> {
            if(!b){
                data.setOrderState(OrderState.MENU_VALIDATION_FAIL);
                Mono.error(new MenuValidationException(order.toString()));
            }

            data.setOrderState(OrderState.MENU_VALIDATION_SUCCESS);
            List<CouponValidation> couponValidations = OrderMapper.INSTANCE.toCouponValidations(order.getOrderCoupons());
            return couponService.orderValidation(couponValidations);
        })
        .flatMap( b -> {
            if(!b){
                data.setOrderState(OrderState.COUPON_VALIDATION_FAIL);
                Mono.error(new CouponValidationException(order.toString()));
            }

            data.setOrderState(OrderState.COUPON_VALIDATION_SUCCESS);
            OrderPayment orderPayment = OrderMapper.INSTANCE.toOrderPayment(data);
            return  paymentService.payment(orderPayment);
        })
       .map( b -> {
           if(!b){
               data.setOrderState(OrderState.PAYMENT_FAIL);
               Mono.error(new PaymentFailException(order.toString()));
           }

           data.setOrderState(OrderState.ORDER_SUCCESS);
           return data;
       });

    }

    
}
