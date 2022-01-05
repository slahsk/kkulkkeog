package com.kkulkkeog.menu.v1.domain.mapper;

import com.kkulkkeog.menu.v1.api.web.GetMenuGroupsRequest;
import com.kkulkkeog.menu.v1.api.web.MenuGroupResponse;
import com.kkulkkeog.menu.v1.api.web.PostMenuGroupRequest;
import com.kkulkkeog.menu.v1.api.web.PutMenuGroupRequest;
import com.kkulkkeog.menu.v1.domain.MenuGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuGroupMapper {
    MenuGroupMapper INSTANCE = Mappers.getMapper(MenuGroupMapper.class);

    MenuGroup toMenuGroup(PostMenuGroupRequest postMenuRequest);

    MenuGroupResponse toMenuGroupResponse(MenuGroup menuGroup);

    MenuGroup toMenuGroup(Long menuGroupNo, PutMenuGroupRequest putMenuGroupRequest);

    @Mapping(target = "deleted", constant = "false")
    MenuGroup toMenuGroup(GetMenuGroupsRequest getMenuGroupsRequest);
}
