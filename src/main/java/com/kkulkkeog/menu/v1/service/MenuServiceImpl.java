package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.api.message.MenuValidation;
import com.kkulkkeog.menu.v1.common.exception.MenuValidationException;
import com.kkulkkeog.menu.v1.domain.Menu;
import com.kkulkkeog.menu.v1.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;

    @Override
    public Mono<Menu> saveMenu(Menu menu) {

        return Mono.just(menu)
                .map(menuRepository::save);
    }

    @Override
    public Flux<Menu> validationOrderMenu(List<MenuValidation> menuValidations) {
       return Flux.fromIterable(menuValidations)
               .collectMap(MenuValidation::getMenuNo)
               .flatMapMany(m ->{

                   List<Menu> menus = menuRepository.findAllById(new ArrayList<>(m.keySet()));

                   return Flux.fromIterable(menus)
                   .doOnNext(menu -> {
                       MenuValidation menuValidation = m.get(menu.getMenuNo());
                       log.debug("validation menu: {}, {}", menuValidation, menu);

                       if(Boolean.FALSE.equals(menu.validation(menuValidation.getShopNo(), menuValidation.getPrice()))){
                           throw new MenuValidationException(menuValidation.toString());
                       }
                   });

               });

    }

}
