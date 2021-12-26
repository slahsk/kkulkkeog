package com.kkulkkeog.shop.v1.service;

import com.kkulkkeog.shop.v1.common.exception.ShopDuplicateException;
import com.kkulkkeog.shop.v1.domain.Shop;
import com.kkulkkeog.shop.v1.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Optional;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShopServiceImplTest {


    @InjectMocks
    ShopServiceImpl shopService;

    @Mock
    ShopRepository shopRepository;

    @Test
    @DisplayName("가게 등록")
    void saveShop() {
        Shop shop = Shop.builder()
                .businessNumber(11111)
                .shopName("맛있쩡")
                .build();

        Shop shop2 = Shop.builder()
                .businessNumber(11111)
                .shopName("흠")
                .build();

        when(shopRepository.findByBusinessNumber(anyInt())).thenReturn(Optional.of(shop2));

        Mono<Shop> shopMono = shopService.saveShop(shop);

        StepVerifier.create(shopMono)
                .expectError(ShopDuplicateException.class)
                .verify();
    }
}