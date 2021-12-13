package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.domain.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@Transactional
@SpringBootTest
@ActiveProfiles(profiles = {"mysql"})
class CouponServiceImplTest_DB {

    @Autowired
    CouponService couponService;



    @Test
    void testSaveCouponUser(){
        Coupon coupon = Coupon.builder()
                .couponNo(1L)
                .build();


        Flux<Coupon> allCoupon = couponService.findAllCoupon(Example.of(coupon));


        StepVerifier.create(allCoupon)
                .expectNextCount(1)
                .verifyComplete();
    }


}
