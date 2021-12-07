package com.kkulkkeog.coupon.service;

import com.kkulkkeog.coupon.api.message.CouponValidation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CouponService {

    Mono<Boolean> validation(List<CouponValidation> couponValidations);
}
