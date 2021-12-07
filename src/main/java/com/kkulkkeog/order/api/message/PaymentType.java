package com.kkulkkeog.order.api.message;

public enum PaymentType {
    CARD("001"),KAKAO_PAY("100"),NAVER_PAY("101"),CASH("200");

    private String code;

    PaymentType(String code) {
        this.code = code;
    }

    public String getPaymentCode(){
        return code;
    }

}
