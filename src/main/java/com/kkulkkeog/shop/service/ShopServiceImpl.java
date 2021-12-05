package com.kkulkkeog.shop.service;

import com.kkulkkeog.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;


}
