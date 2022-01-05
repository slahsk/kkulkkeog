package com.kkulkkeog.order.v1.domain.mapper;

import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.order.v1.api.web.GetOrderRequest;
import com.kkulkkeog.order.v1.api.web.OrderResponse;
import com.kkulkkeog.order.v1.api.web.PostOrderRequest;
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

    Order toOrder(PostOrderRequest postOrderRequest);

    @Mapping(target = "deleted", constant = "false")
    Order toOrder(GetOrderRequest getOrderRequest);

    List<MenuValidation> toMenuValidations(List<OrderMenu> orderMenus);

    List<CouponValidation> toCouponValidations(List<OrderCoupon> orderCoupons);

    OrderPayment toOrderPayment(Order order);

    @Mapping(target = "orderTotalPrice", source = "totalPrice")
    @Mapping(target = "couponNos", source = "orderCoupons",qualifiedByName = "orderCouponNo")
    CouponCalculatePrice toCouponCalculatePrice(Order order);

    @Named("orderCouponNo")
    static Long longToOrderCouponNo(OrderCoupon orderCoupon) {
        return orderCoupon.getOrderCouponNo();
    }

    OrderResponse toOrderResponse(Order order);

}
