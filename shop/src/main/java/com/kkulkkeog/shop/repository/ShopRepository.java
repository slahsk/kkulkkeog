package com.kkulkkeog.shop.repository;

import com.kkulkkeog.shop.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
