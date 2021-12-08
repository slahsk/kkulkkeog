package com.kkulkkeog.order.domain;

public enum OrderState {
    CREATE,
    MENU_VALIDATION_SUCCESS,
    MENU_VALIDATION_FAIL,
    COUPON_VALIDATION_SUCCESS,
    COUPON_VALIDATION_FAIL,
    PAYMENT_FAIL,
    ORDER_SUCCESS
}
