package com.kkulkkeog.shop.v1.common.exception;

public class ShopDuplicateException extends RuntimeException{
    public ShopDuplicateException(int businessNumber) {
        super(String.format("%d 사업자번호가 중복 되어 습니다.", businessNumber));
    }
}
