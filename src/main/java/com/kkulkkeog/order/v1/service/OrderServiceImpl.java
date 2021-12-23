package com.kkulkkeog.order.v1.service;

import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.coupon.v1.service.CouponService;
import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.menu.v1.service.MenuService;
import com.kkulkkeog.coupon.v1.common.exception.CouponValidationException;
import com.kkulkkeog.menu.v1.common.exception.MenuValidationException;
import com.kkulkkeog.order.v1.common.exception.OrderNotFoundException;
import com.kkulkkeog.order.v1.domain.Order;
import com.kkulkkeog.order.v1.api.OrderState;
import com.kkulkkeog.order.v1.domain.mapper.OrderMapper;
import com.kkulkkeog.order.v1.repository.OrderRepository;
import com.kkulkkeog.payment.v1.common.exception.PaymentFailException;
import com.kkulkkeog.payment.v1.api.message.OrderPayment;
import com.kkulkkeog.payment.v1.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final MenuService menuService;
    private final CouponService couponService;

    @Override
    public Mono<Order> findOrder(long orderNo) {
       return Mono.just(orderNo)
               .map(orderRepository::findById)
               .map(order -> order.orElseThrow(() -> new OrderNotFoundException(orderNo)));
    }

    @Override
    public Mono<Order> saveOrder(final Order order) {

        return Mono.just(order)
                .flatMap(orderMono -> {
                    Order data = orderRepository.save(orderMono);
                    List<MenuValidation> menuValidations = OrderMapper.INSTANCE.toMenuValidations(orderMono.getOrderMenus());

                    return menuService.validationOrderMenu(menuValidations)
                            .flatMap( b -> {
                                data.setOrderState(OrderState.MENU_VALIDATION_SUCCESS);
                                List<CouponValidation> couponValidations = OrderMapper.INSTANCE.toCouponValidations(orderMono.getOrderCoupons());
                                return couponService.validationOrderCoupon(couponValidations)
                                        .doOnNext(coupon -> {
                                            log.debug("COUPON_VALIDATION_SUCCESS");
                                            data.setOrderState(OrderState.COUPON_VALIDATION_SUCCESS);
                                        })
                                        .then();
                            })
                            .then(Mono.defer(() -> {
                                CouponCalculatePrice couponCalculatePrice = OrderMapper.INSTANCE.toCouponCalculatePrice(orderMono);

                                return couponService.calculatePrice(couponCalculatePrice)
                                        .doOnNext(aLong -> {
                                            log.debug("COUPON_CALCULATE_SUCCESS");

                                            data.setResultPrice(aLong);
                                            data.setOrderState(OrderState.COUPON_CALCULATE_SUCCESS);
                                        })
                                        .then();
                            }))
                            .then( Mono.defer(() -> {
                                OrderPayment orderPayment = OrderMapper.INSTANCE.toOrderPayment(data);
                                return  paymentService.payment(orderPayment)
                                        .doOnNext(aBoolean -> {
                                            log.debug("ORDER_SUCCESS");

                                            data.setOrderState(OrderState.ORDER_SUCCESS);
                                        })
                                        .then(Mono.just(data));
                            }))
                            .doOnError(MenuValidationException.class, e -> {
                                data.setOrderState(OrderState.MENU_VALIDATION_FAIL);
                                orderRepository.save(data);
                            })
                            .doOnError(CouponValidationException.class, e -> {
                                data.setOrderState(OrderState.COUPON_VALIDATION_FAIL);
                                orderRepository.save(data);
                            })
                            .doOnError(PaymentFailException.class, e -> {
                                data.setOrderState(OrderState.PAYMENT_FAIL);
                                orderRepository.save(data);
                            });
        });

    }

    @Override
    public Mono<Void> deleteOrder(long orderNo) {
        return findOrder(orderNo)
                .doOnNext(order -> {
                    order.setDeleted(true);
                    order.setOrderState(OrderState.CANCEL);
                })
                .then();
    }


}
