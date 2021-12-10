package com.kkulkkeog.delivery.v1.domain.mapper;

import com.kkulkkeog.delivery.v1.api.web.DeliveryResponse;
import com.kkulkkeog.delivery.v1.api.web.GetDeliveryRequest;
import com.kkulkkeog.delivery.v1.api.web.PostDeliveryRequest;
import com.kkulkkeog.delivery.v1.domain.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    Delivery toDelivery(GetDeliveryRequest getDeliveryRequest);

    DeliveryResponse toDeliveryResponse(Delivery delivery);

    Delivery toDelivery(PostDeliveryRequest postCouponRequest);
}

