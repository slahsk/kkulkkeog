package com.kkulkkeog.shop.v1.domain.mapper;

import com.kkulkkeog.shop.v1.api.web.GetShopsRequest;
import com.kkulkkeog.shop.v1.api.web.PostShopRequest;
import com.kkulkkeog.shop.v1.api.web.ShopResponse;
import com.kkulkkeog.shop.v1.api.web.ShopResponse.ShopResponseBuilder;
import com.kkulkkeog.shop.v1.domain.Shop;
import com.kkulkkeog.shop.v1.domain.Shop.ShopBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:21:17+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class ShopMapperImpl implements ShopMapper {

    @Override
    public Shop toShop(GetShopsRequest getShopsRequest) {
        if ( getShopsRequest == null ) {
            return null;
        }

        ShopBuilder shop = Shop.builder();

        return shop.build();
    }

    @Override
    public Shop toShop(PostShopRequest postCouponRequest) {
        if ( postCouponRequest == null ) {
            return null;
        }

        ShopBuilder shop = Shop.builder();

        return shop.build();
    }

    @Override
    public ShopResponse toShopResponse(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopResponseBuilder shopResponse = ShopResponse.builder();

        if ( shop.getShopNo() != null ) {
            shopResponse.shopNo( shop.getShopNo() );
        }
        shopResponse.shopName( shop.getShopName() );
        shopResponse.shopAddress( shop.getShopAddress() );
        shopResponse.shopMessage( shop.getShopMessage() );
        shopResponse.openTime( shop.getOpenTime() );
        shopResponse.closeTime( shop.getCloseTime() );
        shopResponse.created( shop.getCreated() );
        shopResponse.updated( shop.getUpdated() );
        shopResponse.deleted( shop.isDeleted() );

        return shopResponse.build();
    }
}
