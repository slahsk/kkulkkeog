package com.kkulkkeog.menu.service;

import java.util.List;

import com.kkulkkeog.menu.api.message.MenuValidation;
import com.kkulkkeog.menu.domain.MenuGroup;
import com.kkulkkeog.menu.repository.MenuGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;


@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuGroupRepository menuGroupRepository;

    @Override
    public Mono<MenuGroup> saveMenu(MenuGroup menuGroup) {
        MenuGroup data = menuGroupRepository.save(menuGroup);

        return Mono.just(data);

    }

    // 메뉴 유효성 검사
    @Override
    public void validation(List<MenuValidation> menuValidations) {

        menuValidations.stream().forEach( menu -> {


        });

        
    }
}
