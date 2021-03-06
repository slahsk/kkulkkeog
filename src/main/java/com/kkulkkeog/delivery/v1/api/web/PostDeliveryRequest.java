package com.kkulkkeog.delivery.v1.api.web;

import com.kkulkkeog.delivery.v1.api.DeliveryState;
import com.kkulkkeog.delivery.v1.api.DeliveryType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PostDeliveryRequest {
    private String deliveryAddress;

    private String deliveryDescription;

    private Long orderNo;

    private Long shopNo;

    private Long memberNo;

    private DeliveryType deliveryType;

    private DeliveryState deliveryState;

}
