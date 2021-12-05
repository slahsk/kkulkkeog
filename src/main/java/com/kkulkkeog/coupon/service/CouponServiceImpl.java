package com.kkulkkeog.coupon.service;


import com.kkulkkeog.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;

}
