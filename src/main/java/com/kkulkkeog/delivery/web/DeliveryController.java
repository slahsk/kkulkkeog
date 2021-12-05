package com.kkulkkeog.delivery.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class DeliveryController {
    private final DeliveryService deliveryService;


}
