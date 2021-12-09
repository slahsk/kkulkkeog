package com.kkulkkeog.coupon.service;

import com.kkulkkeog.coupon.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.domain.Coupon;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CouponService {

    Flux<Coupon> findAllCoupon(Example<Coupon> example);

    Mono<Boolean> validationOrderCoupon(List<CouponValidation> couponValidations);

    Mono<Long> calculatePrice(CouponCalculatePrice couponCalculatePrice);

    Mono<Coupon> saveCoupon(Coupon coupon);

    Mono<Void> deleteCoupon(long couponNo);

    Mono<Coupon> findCoupon(long couponNo);
}
