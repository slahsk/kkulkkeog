package com.kkulkkeog.menu.v1.service;

import com.kkulkkeog.menu.v1.common.exception.MenuGroupNotFoundException;
import com.kkulkkeog.menu.v1.domain.MenuGroup;
import com.kkulkkeog.menu.v1.repository.MenuGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MenuGroupServiceImpl implements MenuGroupService{
    private final MenuGroupRepository menuGroupRepository;

    @Override
    public Mono<MenuGroup> saveMenuGroup(MenuGroup menuGroup) {
        return Mono.just(menuGroup)
                .map(menuGroupRepository::save);
    }

    @Override
    public Mono<MenuGroup> updateMenuGroup(MenuGroup menuGroup) {
        return saveMenuGroup(menuGroup);
    }

    @Override
    public Mono<MenuGroup> findMenuGroup(long menuGroupNo) {
        return Mono.just(menuGroupNo)
                .map(menuGroupRepository::findById)
                .map( mg -> mg.orElseThrow( () -> new MenuGroupNotFoundException(menuGroupNo)));
    }

    @Override
    public Mono<Page<MenuGroup>> findAllMenuGroups(Example<MenuGroup> example, Pageable pageable) {
        return Mono.just(menuGroupRepository.findAll(example,pageable));
    }

    @Override
    public Mono<Void> deleteMenuGroup(long menuGroupNo) {
        return Mono.just(menuGroupNo)
                .flatMap(this::findMenuGroup)
                .doOnNext( menuGroup -> menuGroup.setDeleted(true))
                .then();
    }
}
