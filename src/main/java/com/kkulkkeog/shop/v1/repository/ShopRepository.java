package com.kkulkkeog.shop.v1.repository;

import com.kkulkkeog.shop.v1.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findByBusinessNumber(int businessNumber);
}
