package com.kkulkkeog.delivery.v1.domain.mapper;

import com.kkulkkeog.delivery.v1.api.web.DeliveryResponse;
import com.kkulkkeog.delivery.v1.api.web.DeliveryResponse.DeliveryResponseBuilder;
import com.kkulkkeog.delivery.v1.api.web.GetDeliveryRequest;
import com.kkulkkeog.delivery.v1.api.web.PostDeliveryRequest;
import com.kkulkkeog.delivery.v1.domain.Delivery;
import com.kkulkkeog.delivery.v1.domain.Delivery.DeliveryBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:19:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public Delivery toDelivery(GetDeliveryRequest getDeliveryRequest) {
        if ( getDeliveryRequest == null ) {
            return null;
        }

        DeliveryBuilder delivery = Delivery.builder();

        return delivery.build();
    }

    @Override
    public DeliveryResponse toDeliveryResponse(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryResponseBuilder deliveryResponse = DeliveryResponse.builder();

        return deliveryResponse.build();
    }

    @Override
    public Delivery toDelivery(PostDeliveryRequest postCouponRequest) {
        if ( postCouponRequest == null ) {
            return null;
        }

        DeliveryBuilder delivery = Delivery.builder();

        return delivery.build();
    }
}
