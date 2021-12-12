package com.kkulkkeog.menu.v1.service;

import java.util.List;
import java.util.Optional;

import com.kkulkkeog.menu.v1.common.exception.MenuValidationException;
import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.menu.v1.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;

    @Override
    public Mono<Boolean> validationOrderMenu(List<MenuValidation> menuValidations) {
       return Flux.fromIterable(menuValidations)
        .flatMap(mv -> {
            Optional<Integer> count = menuRepository.countByShopNoAndMenuNoAndPrice(mv.getShopNo(),mv.getMenuNo(), mv.getPrice());
            return Mono.just(count.orElse(0));
        })
        .as(integerFlux -> integerFlux.reduce(0, Integer::sum).map(i ->  {
            if(i != menuValidations.size()){
               throw new MenuValidationException(menuValidations.toString());
             }

            return true;
        }));
    }

}
