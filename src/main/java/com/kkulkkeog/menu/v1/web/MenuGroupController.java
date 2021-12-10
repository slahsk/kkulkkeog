package com.kkulkkeog.menu.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.menu.v1.api.web.MenuGroupResponse;
import com.kkulkkeog.menu.v1.api.web.PostMenuGroupRequest;
import com.kkulkkeog.menu.v1.domain.MenuGroup;
import com.kkulkkeog.menu.v1.domain.mapper.MenuGroupMapper;
import com.kkulkkeog.menu.v1.service.MenuGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class MenuGroupController {

    private final MenuGroupService menuGroupService;

    @PostMapping("/menu-groups")
    public Mono<MenuGroupResponse> postMenuGroup(@RequestBody PostMenuGroupRequest postMenuGroupRequest){
        MenuGroup menuGroup = MenuGroupMapper.INSTANCE.toMenuGroup(postMenuGroupRequest);


        return menuGroupService.saveMenuGroup(menuGroup).map(MenuGroupMapper.INSTANCE::toMenuGroupResponse);
    }
}
