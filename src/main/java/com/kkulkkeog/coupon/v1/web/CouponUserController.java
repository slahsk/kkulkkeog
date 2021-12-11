package com.kkulkkeog.coupon.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.coupon.v1.api.web.CouponResponse;
import com.kkulkkeog.coupon.v1.api.web.CouponUserResponse;
import com.kkulkkeog.coupon.v1.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import com.kkulkkeog.coupon.v1.domain.CouponUser;
import com.kkulkkeog.coupon.v1.domain.mapper.CouponMapper;
import com.kkulkkeog.coupon.v1.domain.mapper.CouponUserMapper;
import com.kkulkkeog.coupon.v1.service.CouponUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class CouponUserController {
    private final CouponUserService couponUserService;

    @PostMapping("/coupons/{couponNo}/users/{userNo}")
    public Mono<CouponUserResponse> postCouponUser(@PathVariable Long couponNo, @PathVariable Long userNo){
        CouponUser couponUser = CouponUserMapper.INSTANCE.toCouponUser(couponNo, userNo);

        Mono<CouponUser> couponUserMono = couponUserService.saveCouponUser(couponUser);

        return couponUserMono.map(CouponUserMapper.INSTANCE::toCouponUserResponse);
    }

}
