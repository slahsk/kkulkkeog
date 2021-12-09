package com.kkulkkeog.coupon.domain.mapper;

import com.kkulkkeog.coupon.api.web.GetCouponResponse;
import com.kkulkkeog.coupon.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.domain.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponMapper {
    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

    Coupon toCoupon(GetCouponsRequest getCouponsRequest);

    GetCouponResponse toGetCouponResponse(Coupon coupon);

    Coupon toCoupon(PostCouponRequest postCouponRequest);


}
