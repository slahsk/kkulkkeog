package com.kkulkkeog.payment.domain;

import com.kkulkkeog.order.common.exception.PaymentNotExistException;
import com.kkulkkeog.order.domain.Order;
import com.kkulkkeog.payment.api.message.OrderPayment;

public interface Payment {
    boolean payment();

    public static Payment factory(OrderPayment orderPayment){
        Payment payment;
        switch(orderPayment.getPaymentType()){
            case CARD:
                payment = new CardPayment(orderPayment);
                break;
            case KAKAO_PAY:
                payment = new KakaoPayPayment(orderPayment);
                break;
            case NAVER_PAY:
                payment = new NaverPayPayment(orderPayment);
                break;
            case CASH:
                payment = new CashPayment(orderPayment);
                break;
            default:
                throw new PaymentNotExistException(orderPayment.getOrderNo());
        }
        

        return payment;
    }
}
