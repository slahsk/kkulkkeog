package com.kkulkkeog.menu.repository;

import com.kkulkkeog.menu.domain.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuGroupRepository extends JpaRepository<MenuGroup,Long> {


}
