package com.kkulkkeog.order.domain.mapper;

import com.kkulkkeog.coupon.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.order.domain.OrderCoupon;
import com.kkulkkeog.order.domain.OrderMenu;
import com.kkulkkeog.payment.api.message.OrderPayment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<MenuValidation> toMenuValidations(List<OrderMenu> orderMenus);

    List<CouponValidation> toCouponValidations(List<OrderCoupon> orderCoupons);

    OrderPayment toOrderPayment(Order order);

    @Mapping(target = "orderTotalPrice", source = "totalPrice")
    @Mapping(target = "couponNos", source = "orderCoupons",qualifiedByName = "orderCouponNo")
    CouponCalculatePrice toCouponCalculatePrice(Order order);

    @Named("orderCouponNo")
    public static Long longToOrderCouponNo(OrderCoupon orderCoupon) {
        return orderCoupon.getOrderCouponNo();
    }



}
