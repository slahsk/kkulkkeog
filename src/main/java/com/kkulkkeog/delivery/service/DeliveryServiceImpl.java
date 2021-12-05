package com.kkulkkeog.delivery.service;

import com.kkulkkeog.delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{
    private final DeliveryRepository deliveryRepository;


}
