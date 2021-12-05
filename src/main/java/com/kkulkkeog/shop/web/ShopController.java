package com.kkulkkeog.shop.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class ShopController {
    private final ShopService shopService;

}
