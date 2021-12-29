package com.kkulkkeog.menu.v1.repository;

import com.kkulkkeog.menu.v1.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByShopNoAndMenuNoAndPrice(long shopNo,long menuNo, int price);
}
