package com.kkulkkeog.delivery.v1.api.web;

import com.kkulkkeog.delivery.v1.api.DeliveryState;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PutDeliveryStateRequest {
    private DeliveryState deliveryState;
}
