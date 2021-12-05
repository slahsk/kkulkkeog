package com.kkulkkeog.menu.domain.mapper;

import com.kkulkkeog.menu.api.web.PostMenuRequest;
import com.kkulkkeog.menu.domain.MenuGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    MenuGroup toMenuGroup(PostMenuRequest postMenuRequest);
}
