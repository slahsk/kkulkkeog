package com.kkulkkeog.coupon.service;


import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;

    @Override
    public Mono<Boolean> validation(List<CouponValidation> couponValidations) {
        Flux.fromIterable(couponValidations);
        return null;
    }
}
