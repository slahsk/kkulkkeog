package com.kkulkkeog.menu.service;

import com.kkulkkeog.menu.domain.MenuGroup;
import reactor.core.publisher.Mono;

public interface MenuService {
    Mono<MenuGroup> saveMenu(MenuGroup menuGroup);
}
