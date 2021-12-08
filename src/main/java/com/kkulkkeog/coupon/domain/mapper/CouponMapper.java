package com.kkulkkeog.coupon.domain.mapper;

import com.kkulkkeog.coupon.api.message.CouponValidation;
import com.kkulkkeog.coupon.domain.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CouponMapper {
    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

}
