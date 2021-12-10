package com.kkulkkeog.shop.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.coupon.api.web.GetCouponsRequest;
import com.kkulkkeog.coupon.api.web.PostCouponRequest;
import com.kkulkkeog.coupon.domain.Coupon;
import com.kkulkkeog.coupon.domain.mapper.CouponMapper;
import com.kkulkkeog.shop.api.web.GetShopsRequest;
import com.kkulkkeog.shop.api.web.PostShopRequest;
import com.kkulkkeog.shop.api.web.ShopResponse;
import com.kkulkkeog.shop.domain.Shop;
import com.kkulkkeog.shop.domain.mapper.ShopMapper;
import com.kkulkkeog.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/shops")
    public Flux<ShopResponse> getShops(GetShopsRequest getShopsRequest){
        Shop shop = ShopMapper.INSTANCE.toShop(getShopsRequest);

        Flux<Shop> allCoupon = shopService.findAllShops(Example.of(shop));


        return allCoupon.map(ShopMapper.INSTANCE::toShopResponse);
    }

    @GetMapping("/shops/{shopNo}")
    public Mono<ShopResponse> getShop(@PathVariable long shopNo){
        Mono<Shop> shop = shopService.findShop(shopNo);

        return shop.map(ShopMapper.INSTANCE::toShopResponse);
    }

    @PostMapping("/shops")
    public Mono<ShopResponse> postShop(PostShopRequest postCouponRequest){
        Shop shop = ShopMapper.INSTANCE.toShop(postCouponRequest);

        Mono<Shop> saveShop = shopService.saveShop(shop);

        return saveShop.map(ShopMapper.INSTANCE::toShopResponse);
    }

    @DeleteMapping("/shops/{shopNo}")
    public Mono<Void> deleteShop(@PathVariable long shopNo){
        return shopService.deleteShop(shopNo);
    }
}
