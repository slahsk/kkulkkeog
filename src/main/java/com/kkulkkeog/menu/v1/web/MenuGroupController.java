package com.kkulkkeog.menu.v1.web;

import com.kkulkkeog.common.Constant;
import com.kkulkkeog.menu.v1.api.web.GetMenuGroupsRequest;
import com.kkulkkeog.menu.v1.api.web.MenuGroupResponse;
import com.kkulkkeog.menu.v1.api.web.PostMenuGroupRequest;
import com.kkulkkeog.menu.v1.api.web.PutMenuGroupRequest;
import com.kkulkkeog.menu.v1.domain.MenuGroup;
import com.kkulkkeog.menu.v1.domain.mapper.MenuGroupMapper;
import com.kkulkkeog.menu.v1.service.MenuGroupService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_V1)
public class MenuGroupController {

    private final MenuGroupService menuGroupService;

    @GetMapping("/menu-groups")
    public Flux<MenuGroupResponse> getMenuGroups(GetMenuGroupsRequest getMenuGroupsRequest){
        MenuGroup menuGroup = MenuGroupMapper.INSTANCE.toMenuGroup(getMenuGroupsRequest);
        Flux<MenuGroup> menuGroups = menuGroupService.findAllMenuGroups(Example.of(menuGroup));

        return menuGroups.map(MenuGroupMapper.INSTANCE::toMenuGroupResponse);
    }


    @PostMapping("/menu-groups")
    public Mono<MenuGroupResponse> postMenuGroup(@RequestBody PostMenuGroupRequest postMenuGroupRequest){
        MenuGroup menuGroup = MenuGroupMapper.INSTANCE.toMenuGroup(postMenuGroupRequest);

        return menuGroupService.saveMenuGroup(menuGroup).map(MenuGroupMapper.INSTANCE::toMenuGroupResponse);
    }

    @PutMapping("/menu-groups/{menuGroupNo}")
    public Mono<MenuGroupResponse> putMenuGroup(@PathVariable Long menuGroupNo,@RequestBody PutMenuGroupRequest putMenuGroupRequest){
        MenuGroup menuGroup = MenuGroupMapper.INSTANCE.toMenuGroup(menuGroupNo, putMenuGroupRequest);

        return menuGroupService.saveMenuGroup(menuGroup).map(MenuGroupMapper.INSTANCE::toMenuGroupResponse);
    }

    @DeleteMapping("/menu-groups/{menuGroupNo}")
    public Mono<Void> deleteMenuGroup(@PathVariable Long menuGroupNo){
        return menuGroupService.deleteMenuGroup(menuGroupNo);
    }
}
