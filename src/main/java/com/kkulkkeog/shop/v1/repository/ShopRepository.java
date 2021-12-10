package com.kkulkkeog.shop.v1.repository;

import com.kkulkkeog.shop.v1.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
