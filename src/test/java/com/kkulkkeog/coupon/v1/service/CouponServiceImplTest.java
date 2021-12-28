package com.kkulkkeog.coupon.v1.service;

import com.kkulkkeog.coupon.v1.api.message.CouponCalculatePrice;
import com.kkulkkeog.coupon.v1.api.message.CouponValidation;
import com.kkulkkeog.coupon.v1.common.exception.CouponNotAvailableException;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.repository.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CouponServiceImplTest {

    @InjectMocks
    CouponServiceImpl couponService;

    @Mock
    CouponRepository couponRepository;

    List<Coupon> data;


    @BeforeEach
    void setup(){
        LocalDateTime startDate = LocalDateTime.now().minusWeeks(1);
        LocalDateTime endDate = LocalDateTime.now().plusWeeks(1);

        Coupon coupon1 = Coupon.builder().couponNo(1L).startDate(startDate).endDate(endDate).deleted(false).shopNo(11L).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).startDate(startDate).endDate(endDate).deleted(false).shopNo(11L).build();

        data = List.of(coupon1, coupon2);
    }

    @Test
    @DisplayName("쿠폰 사용여부 검사 - 성공")
    void testValidationOrderCouponTrue(){
        CouponValidation couponValidation1 = CouponValidation.builder().couponNo(1).memberNo(100).shopNo(11).build();
        CouponValidation couponValidation2 = CouponValidation.builder().couponNo(2).memberNo(100).shopNo(11).build();


        when(couponRepository.findAllById(anyList())).thenReturn(data);

        Flux<Coupon> couponFlux = couponService.validationOrderCoupon(List.of(couponValidation1, couponValidation2));

        StepVerifier.create(couponFlux)
                .expectNextCount(2L)
                .verifyComplete();
    }

    @Test
    @DisplayName("쿠폰 사용여부 검사 실패(CouponNotAvailableException)")
    void testValidationOrderCouponCouponNotAvailableException(){
        CouponValidation couponValidation1 = CouponValidation.builder().couponNo(1).memberNo(100).shopNo(11).build();
        CouponValidation couponValidation2 = CouponValidation.builder().couponNo(2).memberNo(100).shopNo(11).build();

        data.get(0).setEndDate(LocalDateTime.now().minusDays(1));

        when(couponRepository.findAllById(anyList())).thenReturn(data);

        Flux<Coupon> couponFlux = couponService.validationOrderCoupon(List.of(couponValidation1, couponValidation2));

        StepVerifier.create(couponFlux)
                .expectError(CouponNotAvailableException.class)
                .verify();
    }

    @Test
    @DisplayName("쿠폰 계산")
    void testCalculatePrice(){
        CouponCalculatePrice couponCalculatePrice = CouponCalculatePrice.builder().couponNos(List.of(1L,2L)).orderTotalPrice(5000).build();


        Coupon coupon1 = Coupon.builder().couponNo(1L).shopNo(11L).discountPrice(500L).build();
        Coupon coupon2 = Coupon.builder().couponNo(2L).shopNo(11L).discountPrice(300L).build();

        when(couponRepository.findAllById(anyList())).thenReturn(List.of(coupon1, coupon2));

        Mono<Long> result = couponService.calculatePriceCoupon(couponCalculatePrice);

        StepVerifier.create(result)
                .consumeNextWith(aLong -> {
                    Assertions.assertEquals(4200L, aLong);
                })
                .expectComplete().verify();
    }
}
