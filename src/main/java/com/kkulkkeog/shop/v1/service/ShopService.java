package com.kkulkkeog.shop.v1.service;

import com.kkulkkeog.shop.v1.domain.Shop;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface ShopService {

    Mono<Shop> findShop(long hopNo);

    Mono<Page<Shop>> findAllShops(Example<Shop> example, Pageable pageable);

    Mono<Shop> saveShop(Shop shop);

    Mono<Void> deleteShop(long shopNo);

    Mono<Shop> updateShop(Shop shop);
}
