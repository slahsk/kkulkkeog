package com.kkulkkeog.delivery.v1.api.web;

import com.kkulkkeog.delivery.v1.api.DeliveryState;
import com.kkulkkeog.delivery.v1.api.DeliveryType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class DeliveryResponse {
    private Long deliveryNo;

    private String deliveryAddress;

    private String deliveryDescription;

    private Long orderNo;

    private Long memberNo;

    private Long shopNo;

    private DeliveryType deliveryType;

    private DeliveryState deliveryState;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Boolean deleted;

}
