package com.kkulkkeog.order.repository;

import com.kkulkkeog.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
