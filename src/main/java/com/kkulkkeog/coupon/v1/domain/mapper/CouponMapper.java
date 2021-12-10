package com.kkulkkeog.coupon.v1.domain.mapper;

import com.kkulkkeog.coupon.v1.api.web.CouponResponse;
import com.kkulkkeog.coupon.v1.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.v1.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.v1.domain.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponMapper {
    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

    Coupon toCoupon(GetCouponsRequest getCouponsRequest);

    CouponResponse toGetCouponResponse(Coupon coupon);

    Coupon toCoupon(PostCouponRequest postCouponRequest);


}
