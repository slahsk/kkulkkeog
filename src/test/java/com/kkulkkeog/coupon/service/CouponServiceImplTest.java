package com.kkulkkeog.coupon.service;

import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.domain.Coupon;
import com.kkulkkeog.coupon.repository.CouponRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CouponServiceImplTest {

    @InjectMocks
    CouponServiceImpl couponService;

    @Mock
    CouponRepository couponRepository;


    @Test
    @DisplayName("쿠폰 사용여부 검사: true")
    void testOrderValidationTrue(){
        CouponValidation couponValidation1 = CouponValidation.builder().couponNo(1).memberNo(100).shopNo(11).build();
        CouponValidation couponValidation2 = CouponValidation.builder().couponNo(2).memberNo(100).shopNo(11).build();

        Coupon coupon1 = Coupon.builder().couponNo(1L).memberNo(100).shopNo(11).availableCoupon(true).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).memberNo(100).shopNo(11).availableCoupon(true).build();


        when(couponRepository.findAllById(anyList())).thenReturn(List.of(coupon1, coupon2));

        Mono<Boolean> orderValidation = couponService.orderValidation(List.of(couponValidation1, couponValidation2));

        StepVerifier.create(orderValidation)
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    @DisplayName("쿠폰 사용여부 검사: false")
    void testOrderValidationFalse(){
        CouponValidation couponValidation1 = CouponValidation.builder().couponNo(1).memberNo(100).shopNo(11).build();
        CouponValidation couponValidation2 = CouponValidation.builder().couponNo(2).memberNo(100).shopNo(11).build();

        Coupon coupon1 = Coupon.builder().couponNo(1L).memberNo(100).shopNo(11).availableCoupon(true).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).memberNo(100).shopNo(11).availableCoupon(false).build();


        when(couponRepository.findAllById(anyList())).thenReturn(List.of(coupon1, coupon2));

        Mono<Boolean> orderValidation = couponService.orderValidation(List.of(couponValidation1, couponValidation2));

        StepVerifier.create(orderValidation)
                .expectNext(false)
                .verifyComplete();
    }
}
