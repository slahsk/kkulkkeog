package com.kkulkkeog.menu.domain.mapper;

import com.kkulkkeog.menu.api.web.PostMenuRequest;
import com.kkulkkeog.menu.api.web.PostMenuRequest.Menu;
import com.kkulkkeog.menu.api.web.PostMenuRequest.MenuOption;
import com.kkulkkeog.menu.domain.Menu.MenuBuilder;
import com.kkulkkeog.menu.domain.MenuGroup;
import com.kkulkkeog.menu.domain.MenuGroup.MenuGroupBuilder;
import com.kkulkkeog.menu.domain.MenuOption.MenuOptionBuilder;
import com.kkulkkeog.menu.domain.MenuOptionDetail;
import com.kkulkkeog.menu.domain.MenuOptionDetail.MenuOptionDetailBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-05T21:33:58+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public MenuGroup toMenuGroup(PostMenuRequest postMenuRequest) {
        if ( postMenuRequest == null ) {
            return null;
        }

        MenuGroupBuilder menuGroup = MenuGroup.builder();

        menuGroup.name( postMenuRequest.getName() );
        menuGroup.message( postMenuRequest.getMessage() );
        menuGroup.menuGroupOrder( postMenuRequest.getMenuGroupOrder() );
        menuGroup.menus( menuListToMenuList( postMenuRequest.getMenus() ) );

        return menuGroup.build();
    }

    protected MenuOptionDetail menuOptionDetailToMenuOptionDetail(com.kkulkkeog.menu.api.web.PostMenuRequest.MenuOptionDetail menuOptionDetail) {
        if ( menuOptionDetail == null ) {
            return null;
        }

        MenuOptionDetailBuilder menuOptionDetail1 = MenuOptionDetail.builder();

        menuOptionDetail1.name( menuOptionDetail.getName() );
        menuOptionDetail1.menuOptionDetailOrder( menuOptionDetail.getMenuOptionDetailOrder() );

        return menuOptionDetail1.build();
    }

    protected List<MenuOptionDetail> menuOptionDetailListToMenuOptionDetailList(List<com.kkulkkeog.menu.api.web.PostMenuRequest.MenuOptionDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<MenuOptionDetail> list1 = new ArrayList<MenuOptionDetail>( list.size() );
        for ( com.kkulkkeog.menu.api.web.PostMenuRequest.MenuOptionDetail menuOptionDetail : list ) {
            list1.add( menuOptionDetailToMenuOptionDetail( menuOptionDetail ) );
        }

        return list1;
    }

    protected com.kkulkkeog.menu.domain.MenuOption menuOptionToMenuOption(MenuOption menuOption) {
        if ( menuOption == null ) {
            return null;
        }

        MenuOptionBuilder menuOption1 = com.kkulkkeog.menu.domain.MenuOption.builder();

        menuOption1.name( menuOption.getName() );
        menuOption1.menuOptionOrder( menuOption.getMenuOptionOrder() );
        menuOption1.menuOptionDetails( menuOptionDetailListToMenuOptionDetailList( menuOption.getMenuOptionDetails() ) );

        return menuOption1.build();
    }

    protected List<com.kkulkkeog.menu.domain.MenuOption> menuOptionListToMenuOptionList(List<MenuOption> list) {
        if ( list == null ) {
            return null;
        }

        List<com.kkulkkeog.menu.domain.MenuOption> list1 = new ArrayList<com.kkulkkeog.menu.domain.MenuOption>( list.size() );
        for ( MenuOption menuOption : list ) {
            list1.add( menuOptionToMenuOption( menuOption ) );
        }

        return list1;
    }

    protected com.kkulkkeog.menu.domain.Menu menuToMenu(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuBuilder menu1 = com.kkulkkeog.menu.domain.Menu.builder();

        menu1.name( menu.getName() );
        menu1.price( menu.getPrice() );
        menu1.message( menu.getMessage() );
        menu1.menuOrder( menu.getMenuOrder() );
        menu1.fileNo( menu.getFileNo() );
        menu1.menuOptions( menuOptionListToMenuOptionList( menu.getMenuOptions() ) );

        return menu1.build();
    }

    protected List<com.kkulkkeog.menu.domain.Menu> menuListToMenuList(List<Menu> list) {
        if ( list == null ) {
            return null;
        }

        List<com.kkulkkeog.menu.domain.Menu> list1 = new ArrayList<com.kkulkkeog.menu.domain.Menu>( list.size() );
        for ( Menu menu : list ) {
            list1.add( menuToMenu( menu ) );
        }

        return list1;
    }
}
