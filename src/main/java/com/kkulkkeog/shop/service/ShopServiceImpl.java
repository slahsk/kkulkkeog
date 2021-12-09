package com.kkulkkeog.shop.service;

import com.kkulkkeog.shop.api.exception.ShopNotFoundException;
import com.kkulkkeog.shop.domain.Shop;
import com.kkulkkeog.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;

    @Override
    public Mono<Shop> findShop(long shopNo) {
        return Mono.just(shopRepository.findById(shopNo).orElseThrow(() -> new ShopNotFoundException(shopNo)));
    }

    @Override
    public Flux<Shop> findAllShops(Example<Shop> example) {
        return Flux.fromIterable(shopRepository.findAll(example));
    }

    @Override
    public Mono<Shop> saveShop(Shop shop) {
        Shop save = shopRepository.save(shop);
        return Mono.just(save);
    }

    @Override
    public Mono<Void> deleteShop(long shopNo) {
       return findShop(shopNo)
               .doOnNext(shop -> shop.setDeleted(true))
               .then();
    }

    @Override
    public Mono<Shop> updateShop(Shop shop) {
        Shop save = shopRepository.save(shop);
        return Mono.just(save);
    }
}
