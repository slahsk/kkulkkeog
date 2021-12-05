package com.kkulkkeog.order.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class OrderController {
    private final OrderService orderService;


}
