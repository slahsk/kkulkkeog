package com.kkulkkeog.delivery.v1.domain.mapper;

import com.kkulkkeog.delivery.v1.api.web.DeliveryResponse;
import com.kkulkkeog.delivery.v1.api.web.GetDeliveriesRequest;
import com.kkulkkeog.delivery.v1.api.web.PostDeliveryRequest;
import com.kkulkkeog.delivery.v1.domain.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    @Mapping(target = "deleted", constant = "false")
    Delivery toDelivery(GetDeliveriesRequest getDeliveryRequest);

    DeliveryResponse toDeliveryResponse(Delivery delivery);

    Delivery toDelivery(PostDeliveryRequest postCouponRequest);
}

