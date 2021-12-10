package com.kkulkkeog.payment.v1.api.message;

import com.kkulkkeog.order.v1.api.message.PaymentType;
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
