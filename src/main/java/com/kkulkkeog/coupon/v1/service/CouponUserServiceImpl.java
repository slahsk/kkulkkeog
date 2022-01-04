package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.common.exception.CouponDuplicationException;
import com.kkulkkeog.coupon.v1.common.exception.CouponIssuanceFailException;
import com.kkulkkeog.coupon.v1.domain.CouponUser;
import com.kkulkkeog.coupon.v1.repository.CouponUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CouponUserServiceImpl implements CouponUserService {
    private final CouponUserRepository couponUserRepository;
    private final CouponService couponService;

    @Override
    public Mono<CouponUser> saveCouponUser(CouponUser couponUser) {
       return couponService.findCoupon(couponUser.getCouponNo())
               .publishOn(Schedulers.boundedElastic())
               .doOnNext(coupon -> {
                   if(!coupon.isAvailableCoupon()){
                       throw new CouponIssuanceFailException(couponUser.getCouponNo(), couponUser.getUserNo());
                   }

                   if(Boolean.FALSE.equals(coupon.getDuplication())){
                       Optional<CouponUser> optionalCouponUser = couponUserRepository.findByCouponNo(coupon.getCouponNo());

                       if(optionalCouponUser.isPresent()){
                           throw new CouponDuplicationException(couponUser.getCouponNo(), couponUser.getUserNo());
                       }
                   }
               })
               .then(Mono.just(couponUser))
               .map(couponUserRepository::save);
    }

    @Override
    public Flux<CouponUser> findCouponUser(Example<CouponUser> example) {
        return Flux.fromIterable(couponUserRepository.findAll(example));
    }
}
