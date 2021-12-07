package com.kkulkkeog.payment.domain;

import com.kkulkkeog.order.common.exception.PaymentNotExistException;
import com.kkulkkeog.order.domain.Order;

public interface Payment {
    boolean payment();

    public static Payment factory(Order order){
        Payment payment;
        switch(order.getPaymentType()){
            case CARD:
                payment = new CardPayment();
                break;
            case KAKAO_PAY:
                payment = new KakaoPayPayment();

                break;
            case NAVER_PAY:
                payment = new NaverPayPayment();

                break;
            case CASH:
                payment = new CashPayment();

                break;
            default:
                throw new PaymentNotExistException(order.getOrderNo());
        }
        

        return payment;
    }
}
