package com.kkulkkeog.coupon.service;


import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.domain.Coupon;
import com.kkulkkeog.coupon.domain.mapper.CouponMapper;
import com.kkulkkeog.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;

    @Override
    public Mono<Boolean> orderValidation(List<CouponValidation> couponValidations) {

        List<Long> couponIds = couponValidations.stream().map(CouponValidation::getCouponNo).collect(Collectors.toList());
        Map<Long, Coupon> couponMap = couponRepository.findAllById(couponIds).stream().collect(Collectors.toMap(Coupon::getCouponNo, Function.identity()));

        return Flux.fromIterable(couponValidations)
                .flatMap( couponValidation -> {
                    Coupon coupon = couponMap.get(couponValidation.getCouponNo());

                    boolean orderAvailableCoupon = coupon.isOrderAvailableCoupon(couponValidation.getShopNo(), couponValidation.getMemberNo());

                   return Mono.just(orderAvailableCoupon);
                })
                .filter( b -> b)
                .as(booleanFlux -> booleanFlux.count().map(i -> i == couponValidations.size()));
    }
}
