package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.menu.v1.domain.Menu;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MenuService {

    Mono<Menu> saveMenu(Menu menu);


    Flux<Menu> validationOrderMenu(List<MenuValidation> menuValidations);
}
