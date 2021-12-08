package com.kkulkkeog.order.service;

import com.kkulkkeog.coupon.service.CouponService;
import com.kkulkkeog.menu.service.MenuService;
import com.kkulkkeog.order.api.message.PaymentType;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.order.domain.OrderCoupon;
import com.kkulkkeog.order.domain.OrderMenu;
import com.kkulkkeog.order.domain.OrderState;
import com.kkulkkeog.order.repository.OrderRepository;
import com.kkulkkeog.payment.api.message.OrderPayment;
import com.kkulkkeog.payment.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @InjectMocks
    OrderServiceImpl orderService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    PaymentService paymentService;

    @Mock
    MenuService menuService;

    @Mock
    CouponService couponService;


    Order order;

    @BeforeEach
    void setup(){
        OrderMenu orderMenu1 = OrderMenu.builder().orderMenuNo(1L).menuNo(1).price(2000).quantity(1).build();
        OrderMenu orderMenu2 = OrderMenu.builder().orderMenuNo(2L).menuNo(41).price(200).quantity(5).build();

        OrderCoupon orderCoupon1 = OrderCoupon.builder().orderCouponNo(21L).memberNo(12).shopNo(10).build();
        OrderCoupon orderCoupon2 = OrderCoupon.builder().orderCouponNo(22L).memberNo(12).shopNo(10).build();


        List<OrderMenu> orderMenus = List.of(orderMenu1, orderMenu2);
        List<OrderCoupon> orderCoupons = List.of(orderCoupon1, orderCoupon2);

        order = Order.builder()
                .orderNo(1L)
                .memberNo(12)
                .paymentType(PaymentType.CARD)
                .orderState(OrderState.CREATE)
                .orderMenus(orderMenus)
                .orderCoupons(orderCoupons)
                .build();



    }


    @Test
    @DisplayName("주문 생성 - 성공")
    void testSaveOrder(){
        when(menuService.orderValidation(anyList())).thenReturn(Mono.just(true));
        when(couponService.orderValidation(anyList())).thenReturn(Mono.just(true));
        when(paymentService.payment(any(OrderPayment.class))).thenReturn(Mono.just(true));
        when(orderRepository.save(any(Order.class))).thenReturn(order);


        Mono<Order> orderMono = orderService.saveOrder(order);

        StepVerifier.create(orderMono)
                .consumeNextWith(order1 -> {
                    assertEquals(OrderState.ORDER_SUCCESS, order1.getOrderState());
                })
                .expectComplete()
                .verify();
    }


}
