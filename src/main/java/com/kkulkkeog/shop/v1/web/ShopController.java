package com.kkulkkeog.shop.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.shop.v1.api.web.GetShopsRequest;
import com.kkulkkeog.shop.v1.api.web.PostShopRequest;
import com.kkulkkeog.shop.v1.api.web.ShopResponse;
import com.kkulkkeog.shop.v1.domain.Shop;
import com.kkulkkeog.shop.v1.domain.mapper.ShopMapper;
import com.kkulkkeog.shop.v1.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/shops")
    public Flux<ShopResponse> getShops(GetShopsRequest getShopsRequest){
        Shop shop = ShopMapper.INSTANCE.toShop(getShopsRequest);

        Flux<Shop> allCoupon = shopService.findAllShops(Example.of(shop));


        return allCoupon.map(ShopMapper.INSTANCE::toShopResponse);
    }

    @GetMapping("/shops/{shopNo}")
    public Mono<ShopResponse> getShop(@PathVariable Long shopNo){
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
    public Mono<Void> deleteShop(@PathVariable Long shopNo){
        return shopService.deleteShop(shopNo);
    }
}
