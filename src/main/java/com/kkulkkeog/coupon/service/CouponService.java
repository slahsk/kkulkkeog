package com.kkulkkeog.coupon.service;

import com.kkulkkeog.coupon.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.api.message.CouponValidation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CouponService {

    Mono<Boolean> validationOrderCoupon(List<CouponValidation> couponValidations);


    Mono<Long> calculatePrice(CouponCalculatePrice couponCalculatePrice);
}
