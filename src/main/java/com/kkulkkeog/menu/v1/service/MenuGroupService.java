package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.domain.MenuGroup;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface MenuGroupService {
    Mono<MenuGroup> saveMenuGroup(MenuGroup menuGroup);

    Mono<MenuGroup> updateMenuGroup(MenuGroup menuGroup);

    Mono<MenuGroup> findMenuGroup(long menuGroupNo);

    Mono<Page<MenuGroup>> findAllMenuGroups(Example<MenuGroup> example, Pageable pageable);

    Mono<Void> deleteMenuGroup(long menuGroupNo);
}
