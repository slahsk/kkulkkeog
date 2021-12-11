package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.common.exception.CouponIssuanceFailException;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.domain.CouponUser;
import com.kkulkkeog.coupon.v1.repository.CouponUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CouponUserServiceImpl implements CouponUserService {
    private final CouponUserRepository couponUserRepository;
    private final CouponService couponService;

    @Override
    public Mono<CouponUser> saveCouponUser(CouponUser couponUser) {

       return Mono.just(couponUser)
               .flatMap( c -> couponService.findCoupon(c.getCouponNo()))
               .doOnNext(coupon -> {
                   if(!coupon.isConponAvailable()){
                       throw new CouponIssuanceFailException(couponUser.getCouponNo(), couponUser.getUserNo());
                   }
               })
               .then(Mono.just(couponUser))
               .map(couponUserRepository::save);
    }

    @Override
    public Flux<CouponUser> findCouponUser(CouponUser couponUser) {
        return null;
    }
}
