package com.kkulkkeog.menu.api.message;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuValidation {

    private long menuNo;

    private long shopNo;

    private int price;
    
}