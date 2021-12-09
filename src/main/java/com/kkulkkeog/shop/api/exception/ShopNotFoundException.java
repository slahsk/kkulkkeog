package com.kkulkkeog.shop.api.exception;

public class ShopNotFoundException extends RuntimeException{
    public ShopNotFoundException(long shopNo) {
        super(String.format("%d 가게를 찾을 수 없습니다.", shopNo));
    }
}
