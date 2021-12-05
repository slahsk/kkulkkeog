package com.kkulkkeog.menu.api.web;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostMenuResponse {

    private String name;

    private String message;

    private int menuGroupOrder;

    private List<Menu> menus;

    @Getter
    @Builder
    public static class Menu{
        private String name;

        private int price;

        private String message;

        private int menuOrder;

        private long fileNo;

        private List<MenuOption> menuOptions;
    }

    @Getter
    @Builder
    public static class MenuOption{
        private String name;

        private int menuOptionOrder;

        private List<MenuOptionDetail> menuOptionDetails;
    }

    @Getter
    @Builder
    public static class MenuOptionDetail{

        private String name;

        private int menuOptionDetailOrder;
    }
}
