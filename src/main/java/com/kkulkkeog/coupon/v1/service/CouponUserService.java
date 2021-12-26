package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.domain.CouponUser;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponUserService {
    Mono<CouponUser> saveCouponUser(CouponUser couponUser);

    Flux<CouponUser> findCouponUser(Example<CouponUser> example);
}
