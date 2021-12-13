package com.kkulkkeog.coupon.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.coupon.v1.api.web.CouponResponse;
import com.kkulkkeog.coupon.v1.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.v1.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.domain.mapper.CouponMapper;
import com.kkulkkeog.coupon.v1.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
@Slf4j
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/coupons")
    public Mono<Page<CouponResponse>> getCoupons(GetCouponsRequest getCouponsRequest, Pageable pageable){
        Coupon coupon = CouponMapper.INSTANCE.toCoupon(getCouponsRequest);

        Mono<Page<Coupon>> couponPage = couponService.findAllCoupon(Example.of(coupon), pageable);

        return couponPage.map(coupons -> coupons.map(CouponMapper.INSTANCE::toGetCouponResponse));
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
