package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.domain.MenuGroup;
import reactor.core.publisher.Mono;

public interface MenuGroupService {
    Mono<MenuGroup> saveMenuGroup(MenuGroup menuGroup);
}
