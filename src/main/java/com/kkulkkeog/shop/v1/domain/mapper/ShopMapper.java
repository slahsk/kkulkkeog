package com.kkulkkeog.shop.v1.domain.mapper;

import com.kkulkkeog.shop.v1.api.web.GetShopsRequest;
import com.kkulkkeog.shop.v1.api.web.PostShopRequest;
import com.kkulkkeog.shop.v1.api.web.ShopResponse;
import com.kkulkkeog.shop.v1.domain.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    @Mapping(target = "deleted", constant = "false")
    Shop toShop(GetShopsRequest getShopsRequest);

    Shop toShop(PostShopRequest postCouponRequest);

    ShopResponse toShopResponse(Shop shop);
}
