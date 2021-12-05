package com.kkulkkeog.coupon.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class CouponController {
    private final CouponService couponService;


}
