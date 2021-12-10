package com.kkulkkeog.delivery.v1.repository;

import com.kkulkkeog.delivery.v1.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
