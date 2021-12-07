package com.kkulkkeog.menu.service;

import java.util.List;

import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.menu.domain.MenuGroup;
import reactor.core.publisher.Mono;

public interface MenuService {
    Mono<MenuGroup> saveMenu(Mono<MenuGroup> menuGroup);

    Mono<Boolean> validation(List<MenuValidation> menuValidations);
}
