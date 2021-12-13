package com.kkulkkeog.order.v1.service;

import com.kkulkkeog.coupon.v1.common.exception.CouponValidationException;
import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.service.CouponService;
import com.kkulkkeog.menu.v1.common.exception.MenuValidationException;
import com.kkulkkeog.menu.v1.service.MenuService;
import com.kkulkkeog.order.v1.api.message.PaymentType;
import com.kkulkkeog.order.v1.domain.Order;
import com.kkulkkeog.order.v1.domain.OrderCoupon;
import com.kkulkkeog.order.v1.domain.OrderMenu;
import com.kkulkkeog.order.v1.domain.OrderState;
import com.kkulkkeog.order.v1.repository.OrderRepository;
import com.kkulkkeog.payment.v1.common.exception.PaymentFailException;
import com.kkulkkeog.payment.v1.api.message.OrderPayment;
import com.kkulkkeog.payment.v1.service.PaymentService;
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
class OrderServiceImplTest {

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
                .userNo(12)
                .paymentType(PaymentType.CARD)
                .orderState(OrderState.CREATE)
                .orderMenus(orderMenus)
                .orderCoupons(orderCoupons)
                .build();



    }


    @Test
    @DisplayName("주문 생성 - 성공")
    void testSaveOrderSuccess(){
        when(menuService.validationOrderMenu(anyList())).thenReturn(Mono.just(true));
        when(couponService.validationOrderCoupon(anyList())).thenReturn(Mono.just(true));
        when(couponService.calculatePrice(any(CouponCalculatePrice.class))).thenReturn(Mono.just(2000L));
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

    @Test
    @DisplayName("주문 생성 - 실패(MenuValidationException)")
    void testSaveOrderMenuValidationException(){
        when(menuService.validationOrderMenu(anyList())).thenReturn(Mono.error(new MenuValidationException("test")));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Mono<Order> orderMono = orderService.saveOrder(order);

        StepVerifier.create(orderMono)
                .expectError(MenuValidationException.class)
                .verify();

        verify(orderRepository, times(2)).save(any(Order.class));
    }

    @Test
    @DisplayName("주문 생성 - 실패(CouponValidationException)")
    void testSaveOrderCouponValidationException(){
        when(menuService.validationOrderMenu(anyList())).thenReturn(Mono.just(true));
        when(couponService.validationOrderCoupon(anyList())).thenReturn(Mono.error(new CouponValidationException("test")));

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Mono<Order> orderMono = orderService.saveOrder(order);

        StepVerifier.create(orderMono)
                .expectError(CouponValidationException.class)
                .verify();

        verify(orderRepository, times(2)).save(any(Order.class));
    }

    @Test
    @DisplayName("주문 생성 - 실패(PaymentFailException)")
    void testSaveOrderPaymentFailException(){
        when(menuService.validationOrderMenu(anyList())).thenReturn(Mono.just(true));
        when(couponService.validationOrderCoupon(anyList())).thenReturn(Mono.just(true));
        when(couponService.calculatePrice(any(CouponCalculatePrice.class))).thenReturn(Mono.just(2000L));
        when(paymentService.payment(any(OrderPayment.class))).thenReturn(Mono.error(new PaymentFailException("test")));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Mono<Order> orderMono = orderService.saveOrder(order);

        StepVerifier.create(orderMono)
                .expectError(PaymentFailException.class)
                .verify();

        verify(orderRepository, times(2)).save(any(Order.class));
    }


}
