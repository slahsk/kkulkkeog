package com.kkulkkeog.order.v1.api.web;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostOrderRequest {

    private Long totalPrice;

    private Long resultPrice;

    private Long couponNo;

    private List<OrderMenu> orderMenus;

    private List<OrderCoupon> orderCoupons;

    private String paymentType;

    @Getter
    @Builder
    public static class OrderMenu{
        private Long menuNo;

        private Long price;
    }

    @Getter
    @Builder
    public static class OrderCoupon{
        private Long couponNo;

        private Long userNo;
    }
}
