package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.common.exception.CouponIssuanceFailException;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.domain.CouponUser;
import com.kkulkkeog.coupon.v1.repository.CouponUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CouponUserServiceImplTest {

    @InjectMocks
    CouponUserServiceImpl couponUserService;

    @Mock
    CouponUserRepository couponUserRepository;

    @Mock
    CouponService couponService;

    CouponUser couponUser;

    Coupon coupon;

    @BeforeEach
    void setUp(){
       couponUser = CouponUser.builder()
                .userNo(10)
                .couponNo(1)
                .build();


       LocalDateTime startDate = LocalDateTime.now().minusWeeks(1);
       LocalDateTime endDate = LocalDateTime.now().plusWeeks(1);

       coupon = Coupon.builder()
                .startDate(startDate)
                .endDate(endDate)
                .deleted(false)
                .build();
    }

    @Test
    @DisplayName("사용자 쿠폰 발행 - 성공")
    void testSaveCouponUser(){


        when(couponService.findCoupon(anyLong())).thenReturn(Mono.just(coupon));
        when(couponUserRepository.save(any(CouponUser.class))).thenReturn(couponUser);

        Mono<CouponUser> couponUserMono = couponUserService.saveCouponUser(couponUser);


        StepVerifier.create(couponUserMono)
                .expectNext(couponUser)
                .verifyComplete();

        verify(couponUserRepository, times(1)).save(any(CouponUser.class));
    }


    @Test
    @DisplayName("사용자 쿠폰 발행 - 실패(잘못된 쿠폰발행 요청)")
    void testSaveCouponUserCouponIssuanceFailException(){
        coupon.setStartDate(LocalDateTime.now().minusWeeks(2));
        coupon.setEndDate(LocalDateTime.now().minusWeeks(1));

        when(couponService.findCoupon(anyLong())).thenReturn(Mono.just(coupon));

        Mono<CouponUser> couponUserMono = couponUserService.saveCouponUser(couponUser);


        StepVerifier.create(couponUserMono)
                .expectError(CouponIssuanceFailException.class)
                .verify();

        verify(couponUserRepository, times(0)).save(any(CouponUser.class));
    }

}