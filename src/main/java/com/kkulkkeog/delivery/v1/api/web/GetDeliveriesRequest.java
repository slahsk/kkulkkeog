package com.kkulkkeog.delivery.v1.api.web;

import com.kkulkkeog.delivery.v1.api.DeliveryState;
import com.kkulkkeog.delivery.v1.api.DeliveryType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class GetDeliveriesRequest {
    private Long shopNo;

    private DeliveryType deliveryType;

    private DeliveryState deliveryState;
}
