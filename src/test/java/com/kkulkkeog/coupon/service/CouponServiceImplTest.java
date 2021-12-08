package com.kkulkkeog.coupon.service;

import com.kkulkkeog.coupon.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CouponServiceImplTest {

    @InjectMocks
    CouponServiceImpl couponService;

    @Mock
    CouponRepository couponRepository;


    @Test
    void testOrderValidation(){


    }
}
