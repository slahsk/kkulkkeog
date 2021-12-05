package com.kkulkkeog.menu.service;

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
}
