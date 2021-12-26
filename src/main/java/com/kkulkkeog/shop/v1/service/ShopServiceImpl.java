package com.kkulkkeog.shop.v1.service;

import com.kkulkkeog.shop.v1.common.exception.ShopDuplicateException;
import com.kkulkkeog.shop.v1.common.exception.ShopNotFoundException;
import com.kkulkkeog.shop.v1.domain.Shop;
import com.kkulkkeog.shop.v1.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
@Transactional
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;

    @Override
    public Mono<Shop> findShop(long shopNo) {
         return Mono.just(shopNo)
                 .map(shopRepository::findById)
                 .map(shop -> shop.orElseThrow(() -> new ShopNotFoundException(shopNo)));
    }

    @Override
    public Mono<Page<Shop>> findAllShops(Example<Shop> example, Pageable pageable) {
        return Mono.just(shopRepository.findAll(example, pageable));
    }

    @Override
    public Mono<Shop> saveShop(Shop shop) {
        return Mono.just(shop)
                .publishOn(Schedulers.boundedElastic())
                .map(s -> {
                    if( shopRepository.findByBusinessNumber( s.getBusinessNumber()).isPresent()){
                        throw new ShopDuplicateException(s.getBusinessNumber());
                    }

                    return shopRepository.save(s);
                });
    }

    @Override
    public Mono<Void> deleteShop(long shopNo) {
       return findShop(shopNo)
               .doOnNext(shop -> shop.setDeleted(true))
               .then();
    }

    @Override
    public Mono<Shop> updateShop(Shop shop) {
       return Mono.just(shop)
               .map(shopRepository::save);
    }
}
