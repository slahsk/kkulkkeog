package com.kkulkkeog.menu.service;

import java.util.List;
import java.util.Optional;

import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.menu.domain.MenuGroup;
import com.kkulkkeog.menu.repository.MenuGroupRepository;
import com.kkulkkeog.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuGroupRepository menuGroupRepository;

    private  final MenuRepository menuRepository;

    @Override
    public Mono<MenuGroup> saveMenu(Mono<MenuGroup> menuGroup) {
        return  menuGroup.map(menuGroupRepository::save);
    }

    @Override
    public Mono<Boolean> orderValidation(List<MenuValidation> menuValidations) {

       return Flux.fromIterable(menuValidations)
        .flatMap(menuValidation -> {
            Optional<Integer> count = menuRepository.countByShopNoAndMenuNoAndPrice(menuValidation.getShopNo(),menuValidation.getMenuNo(), menuValidation.getPrice());
            return Mono.just(count.orElse(0));
        })
        .as(integerFlux -> integerFlux.reduce(0, (x1, x2) -> x1 + x2).map(i -> i == menuValidations.size()));
    }

}
