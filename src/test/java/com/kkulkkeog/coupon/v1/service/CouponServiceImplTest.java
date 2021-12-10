package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.common.exception.CouponValidationException;
import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.repository.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    @DisplayName("쿠폰 사용여부 검사 성공")
    void testValidationOrderCouponTrue(){
        CouponValidation couponValidation1 = CouponValidation.builder().couponNo(1).memberNo(100).shopNo(11).build();
        CouponValidation couponValidation2 = CouponValidation.builder().couponNo(2).memberNo(100).shopNo(11).build();

        Coupon coupon1 = Coupon.builder().couponNo(1L).memberNo(100).shopNo(11).availableCoupon(true).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).memberNo(100).shopNo(11).availableCoupon(true).build();


        when(couponRepository.findAllById(anyList())).thenReturn(List.of(coupon1, coupon2));

        Mono<Boolean> orderValidation = couponService.validationOrderCoupon(List.of(couponValidation1, couponValidation2));

        StepVerifier.create(orderValidation)
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    @DisplayName("쿠폰 사용여부 검사 실패(CouponValidationException)")
    void testValidationOrderCouponCouponValidationException(){
        CouponValidation couponValidation1 = CouponValidation.builder().couponNo(1).memberNo(100).shopNo(11).build();
        CouponValidation couponValidation2 = CouponValidation.builder().couponNo(2).memberNo(100).shopNo(11).build();

        Coupon coupon1 = Coupon.builder().couponNo(1L).memberNo(100).shopNo(11).availableCoupon(true).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).memberNo(100).shopNo(11).availableCoupon(false).build();


        when(couponRepository.findAllById(anyList())).thenReturn(List.of(coupon1, coupon2));

        Mono<Boolean> orderValidation = couponService.validationOrderCoupon(List.of(couponValidation1, couponValidation2));

        StepVerifier.create(orderValidation)
                .expectError(CouponValidationException.class)
                .verify();
    }

    @Test
    @DisplayName("쿠폰 계산")
    void testCalculatePrice(){
        CouponCalculatePrice couponCalculatePrice = CouponCalculatePrice.builder().couponNos(List.of(1L,2L)).orderTotalPrice(5000).build();


        Coupon coupon1 = Coupon.builder().couponNo(1L).memberNo(100).shopNo(11).price(500).availableCoupon(true).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).memberNo(100).shopNo(11).price(300).availableCoupon(true).build();

        when(couponRepository.findAllById(anyList())).thenReturn(List.of(coupon1, coupon2));

        Mono<Long> result = couponService.calculatePrice(couponCalculatePrice);

        StepVerifier.create(result)
                .consumeNextWith(aLong -> {
                    Assertions.assertEquals(4200L, aLong);
                })
                .expectComplete().verify();
    }
}
