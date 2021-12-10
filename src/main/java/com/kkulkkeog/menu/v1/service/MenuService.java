package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MenuService {

    Mono<Boolean> validationOrderMenu(List<MenuValidation> menuValidations);
}
