package com.kkulkkeog.coupon.v1.service;


import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.coupon.v1.common.exception.CouponNotAvailableException;
import com.kkulkkeog.coupon.v1.common.exception.CouponNotFoundException;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;

    @Override
    public Mono<Page<Coupon>> findAllCoupon(Example<Coupon> example, Pageable pageable){
        return Mono.just(couponRepository.findAll(example, pageable));
    }

    @Override
    public Mono<Coupon> saveCoupon(Coupon coupon) {
        return Mono.just(coupon)
                .map(couponRepository::save);
    }

    @Override
    public Mono<Void> deleteCoupon(long couponNo) {
        return findCoupon(couponNo)
        .doOnNext(coupon -> coupon.setDeleted(true)).then();
    }

    @Override
    public Mono<Coupon> findCoupon(long couponNo) {
        return Mono.just(couponNo)
                .map(couponRepository::findById)
                .map(coupon -> coupon.orElseThrow(() -> new CouponNotFoundException(couponNo)));
    }


    @Override
    public Flux<Coupon> validationOrderCoupon(List<CouponValidation> couponValidations) {
        return Flux.fromIterable(couponValidations)
                .as( coupons -> coupons
                        .map(CouponValidation::getCouponNo)
                        .collectList()
                        .flatMapMany(longs ->
                                Flux.fromIterable(couponRepository.findAllById(longs))
                                .flatMap(coupon -> {
                                    if(Boolean.FALSE.equals(coupon.isAvailableCoupon())){
                                        return Flux.error(new CouponNotAvailableException(coupon.getCouponNo()));
                                    }

                                    return Mono.just(coupon);
                                }
                        ))
                );
    }


    @Override
    public Mono<Long> calculatePriceCoupon(CouponCalculatePrice couponCalculatePrice) {
        return Mono.just(couponCalculatePrice)
                .publishOn(Schedulers.boundedElastic())
                .map( o -> {
                    long sum = couponRepository.findAllById(couponCalculatePrice.getCouponNos())
                            .stream()
                            .mapToLong(Coupon::getDiscountPrice).sum();
                    return  couponCalculatePrice.getOrderTotalPrice() - sum;
                });
    }


}
