package com.kkulkkeog.shop.v1.service;

import com.kkulkkeog.shop.v1.domain.Shop;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShopService {

    Mono<Shop> findShop(long hopNo);

    Flux<Shop> findAllShops(Example<Shop> example);

    Mono<Shop> saveShop(Shop shop);

    Mono<Void> deleteShop(long shopNo);

    Mono<Shop> updateShop(Shop shop);
}
