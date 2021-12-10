package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.domain.MenuGroup;
import com.kkulkkeog.menu.v1.repository.MenuGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService{
    private final MenuGroupRepository menuGroupRepository;

    @Override
    public Mono<MenuGroup> saveMenuGroup(MenuGroup menuGroup) {
        return  Mono.just(menuGroupRepository.save(menuGroup));
    }
}
