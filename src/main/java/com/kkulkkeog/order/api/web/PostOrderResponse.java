package com.kkulkkeog.order.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostOrderResponse {
    private long orderId;
}
