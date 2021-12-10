package com.kkulkkeog.order.v1.api.web;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostOrderRequest {

    private long totalPrice;

    private long memberCouponNo;

    private long couponNo;

    private List<OrderMenu> orderMenus;

    private List<OrderCoupon> orderCoupons;

    private String paymentType;

    @Getter
    @Builder
    public static class OrderMenu{
        private long menuNo;

        private long price;
    }

    @Getter
    @Builder
    public static class OrderCoupon{
        private long couponNo;

        private long memberNo;
    }
}
