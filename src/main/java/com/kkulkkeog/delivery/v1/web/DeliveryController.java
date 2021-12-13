package com.kkulkkeog.delivery.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.delivery.v1.api.web.DeliveryResponse;
import com.kkulkkeog.delivery.v1.api.web.GetDeliveryRequest;
import com.kkulkkeog.delivery.v1.api.web.PostDeliveryRequest;
import com.kkulkkeog.delivery.v1.domain.Delivery;
import com.kkulkkeog.delivery.v1.domain.mapper.DeliveryMapper;
import com.kkulkkeog.delivery.v1.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping("/deliveries")
    public Mono<Page<DeliveryResponse>> getDeliveries(GetDeliveryRequest getDeliveryRequest, Pageable pageable){
        Delivery delivery = DeliveryMapper.INSTANCE.toDelivery(getDeliveryRequest);

        Mono<Page<Delivery>> deliveries = deliveryService.findAllDeliveries(Example.of(delivery),pageable);

        return deliveries.map(d -> d.map(DeliveryMapper.INSTANCE::toDeliveryResponse));
    }

    @GetMapping("/deliveries/{deliveryNo}")
    public Mono<DeliveryResponse> getDelivery(@PathVariable long deliveryNo){
        Mono<Delivery> delivery = deliveryService.findDelivery(deliveryNo);

        return delivery.map(DeliveryMapper.INSTANCE::toDeliveryResponse);
    }

    @PostMapping("/deliveries")
    public Mono<DeliveryResponse> postRDelivery(PostDeliveryRequest postCouponRequest){
        Delivery delivery = DeliveryMapper.INSTANCE.toDelivery(postCouponRequest);

        Mono<Delivery> saveDelivery = deliveryService.saveDelivery(delivery);

        return saveDelivery.map(DeliveryMapper.INSTANCE::toDeliveryResponse);
    }

    @DeleteMapping("/deliveries/{deliveryNo}")
    public Mono<Void> deleteDelivery(@PathVariable long deliveryNo){
        return deliveryService.deleteDelivery(deliveryNo);
    }
}
