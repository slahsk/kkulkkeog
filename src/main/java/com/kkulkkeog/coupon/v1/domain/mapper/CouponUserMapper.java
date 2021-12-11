package com.kkulkkeog.coupon.v1.domain.mapper;

import com.kkulkkeog.coupon.v1.api.web.CouponUserResponse;
import com.kkulkkeog.coupon.v1.domain.CouponUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponUserMapper {
    CouponUserMapper INSTANCE = Mappers.getMapper(CouponUserMapper.class);

    CouponUser toCouponUser(Long couponNo, Long userNo);

    CouponUserResponse toCouponUserResponse(CouponUser couponUser);
}
