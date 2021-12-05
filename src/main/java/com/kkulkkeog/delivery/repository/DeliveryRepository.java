package com.kkulkkeog.delivery.repository;

import com.kkulkkeog.delivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
