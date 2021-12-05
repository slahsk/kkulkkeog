package com.kkulkkeog.menu.api.web;


import java.util.List;

public class PostMenuRequest {

    private String name;

    private String message;

    private int menuGroupOrder;

    private List<Menu> menus;


    public static class Menu{
        private String name;

        private int price;

        private String message;

        private int menuOrder;

        private List<MenuOption> menuOptions;
    }

    public static class MenuOption{
        private String name;

        private int menuOptionOrder;

        private List<MenuOptionDetail> menuOptionDetails;
    }

    public static class MenuOptionDetail{

        private String name;

        private int menuOptionDetailOrder;
    }
}
