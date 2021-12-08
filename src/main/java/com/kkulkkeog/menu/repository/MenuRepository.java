package com.kkulkkeog.menu.repository;

import com.kkulkkeog.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Integer> countByShopNoAndMenuNoAndPrice(long shopNo,long menuNo, int price);
}
