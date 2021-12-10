package com.kkulkkeog.menu.v1.domain.mapper;

import com.kkulkkeog.menu.v1.api.web.MenuGroupResponse;
import com.kkulkkeog.menu.v1.api.web.MenuGroupResponse.MenuGroupResponseBuilder;
import com.kkulkkeog.menu.v1.api.web.PostMenuGroupRequest;
import com.kkulkkeog.menu.v1.domain.MenuGroup;
import com.kkulkkeog.menu.v1.domain.MenuGroup.MenuGroupBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:19:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class MenuGroupMapperImpl implements MenuGroupMapper {

    @Override
    public MenuGroup toMenuGroup(PostMenuGroupRequest postMenuRequest) {
        if ( postMenuRequest == null ) {
            return null;
        }

        MenuGroupBuilder menuGroup = MenuGroup.builder();

        menuGroup.menuGroupName( postMenuRequest.getMenuGroupName() );
        menuGroup.menuGroupDescription( postMenuRequest.getMenuGroupDescription() );
        menuGroup.menuGroupOrder( postMenuRequest.getMenuGroupOrder() );

        return menuGroup.build();
    }

    @Override
    public MenuGroupResponse toMenuGroupResponse(MenuGroup menuGroup) {
        if ( menuGroup == null ) {
            return null;
        }

        MenuGroupResponseBuilder menuGroupResponse = MenuGroupResponse.builder();

        return menuGroupResponse.build();
    }
}
