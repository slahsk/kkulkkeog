package com.kkulkkeog.menu.api.message;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuValidation {

    private String menuName;

    private int price;
    
}