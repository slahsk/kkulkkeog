package com.kkulkkeog.coupon.v1.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CouponTest {

    Coupon coupon;

    @BeforeEach
    void setUp() {
        LocalDateTime startDate = LocalDateTime.now().minusWeeks(1);
        LocalDateTime endDate = LocalDateTime.now().plusWeeks(1);


        coupon = Coupon.builder()
                .startDate(startDate)
                .endDate(endDate)
                .deleted(false)
                .build();
    }

    @Test
    @DisplayName("발행 가능한 쿠폰 검사")
    void testIsConponAvailable() {
        assertTrue(coupon.isConponAvailable());
    }


}