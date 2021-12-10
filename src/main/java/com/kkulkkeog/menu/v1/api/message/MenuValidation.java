package com.kkulkkeog.menu.v1.api.message;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MenuValidation {

    private long menuNo;

    private long shopNo;

    private int price;
    
}