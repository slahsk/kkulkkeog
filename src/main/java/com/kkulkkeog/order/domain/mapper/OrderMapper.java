package com.kkulkkeog.order.domain.mapper;

import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.order.domain.OrderCoupon;
import com.kkulkkeog.order.domain.OrderMenu;
import com.kkulkkeog.payment.api.message.OrderPayment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    List<MenuValidation> toMenuValidations(List<OrderMenu> orderMenus);

    List<CouponValidation> toCouponValidations(List<OrderCoupon> orderCoupons);

    OrderPayment toOrderPayment(Order order);
}
