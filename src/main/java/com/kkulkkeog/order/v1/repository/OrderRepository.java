package com.kkulkkeog.order.v1.repository;

import com.kkulkkeog.order.v1.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
