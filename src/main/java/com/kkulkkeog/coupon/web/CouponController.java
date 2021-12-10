package com.kkulkkeog.coupon.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.coupon.api.web.CouponResponse;
import com.kkulkkeog.coupon.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.domain.Coupon;
import com.kkulkkeog.coupon.domain.mapper.CouponMapper;
import com.kkulkkeog.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/coupons")
    public Flux<CouponResponse> getCoupons(GetCouponsRequest getCouponsRequest){
        Coupon coupon = CouponMapper.INSTANCE.toCoupon(getCouponsRequest);

        Flux<Coupon> allCoupon = couponService.findAllCoupon(Example.of(coupon));

        return allCoupon.map( CouponMapper.INSTANCE::toGetCouponResponse);
    }

    @GetMapping("/coupons/{couponNo}")
    public Mono<CouponResponse> getCoupon(@PathVariable long couponNo){
        Mono<Coupon> coupon = couponService.findCoupon(couponNo);

        return coupon.map(CouponMapper.INSTANCE::toGetCouponResponse);
    }

    @PostMapping("/coupons")
    public Mono<CouponResponse> postCoupon(PostCouponRequest postCouponRequest){
        Coupon coupon = CouponMapper.INSTANCE.toCoupon(postCouponRequest);

        Mono<Coupon> saveCoupon = couponService.saveCoupon(coupon);

        return saveCoupon.map(CouponMapper.INSTANCE::toGetCouponResponse);
    }

    @DeleteMapping("/coupons/{couponNo}")
    public Mono<Void> deleteCoupon(@PathVariable long couponNo){
        return couponService.deleteCoupon(couponNo);
    }


}
