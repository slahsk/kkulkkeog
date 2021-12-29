package com.kkulkkeog.menu.v1.common.exception;

public class MenuGroupNotFoundException extends MenuException{
    public MenuGroupNotFoundException(long menuGroupNo) {
        super(String.format("%d 메뉴 그룹이 없습니다.",menuGroupNo));
    }
}
