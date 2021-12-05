package com.kkulkkeog.menu.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.menu.api.web.PostMenuRequest;
import com.kkulkkeog.menu.domain.MenuGroup;
import com.kkulkkeog.menu.domain.mapper.MenuMapper;
import com.kkulkkeog.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class MunuController {

    private final MenuService menuService;

    @PostMapping("/menus")
    public void postMenu(@RequestBody PostMenuRequest postMenuRequest){
        Mono<MenuGroup> menuGroupMono = menuService.saveMenu(MenuMapper.INSTANCE.toMenuGroup(postMenuRequest));


    }
}
