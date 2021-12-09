package com.kkulkkeog.shop.domain.mapper;

import com.kkulkkeog.coupon.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.domain.Coupon;
import com.kkulkkeog.shop.api.web.GetShopsRequest;
import com.kkulkkeog.shop.api.web.PostShopRequest;
import com.kkulkkeog.shop.domain.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    Shop toShop(GetShopsRequest getShopsRequest);

    Shop toShop(PostShopRequest postCouponRequest);
}
