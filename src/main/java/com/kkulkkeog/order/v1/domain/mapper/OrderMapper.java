package com.kkulkkeog.order.v1.domain.mapper;

import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.order.v1.domain.Order;
import com.kkulkkeog.order.v1.domain.OrderCoupon;
import com.kkulkkeog.order.v1.domain.OrderMenu;
import com.kkulkkeog.payment.v1.api.message.OrderPayment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
