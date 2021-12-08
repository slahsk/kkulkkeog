package com.kkulkkeog.payment.api.message;

import com.kkulkkeog.order.api.message.PaymentType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderPayment {
    private long orderNo;

    private long resultPrice;

    private long memberNo;

    private PaymentType paymentType;
}
