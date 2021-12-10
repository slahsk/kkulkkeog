package com.kkulkkeog.order.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.order.v1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class OrderController {
    private final OrderService orderService;


}
