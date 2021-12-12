package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.domain.MenuGroup;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuGroupService {
    Mono<MenuGroup> saveMenuGroup(MenuGroup menuGroup);

    Mono<MenuGroup> updateMenuGroup(MenuGroup menuGroup);

    Mono<MenuGroup> findMenuGroup(long menuGroupNo);

    Flux<MenuGroup> findAllMenuGroups(Example<MenuGroup> example);

    Mono<Void> deleteMenuGroup(long menuGroupNo);
}
