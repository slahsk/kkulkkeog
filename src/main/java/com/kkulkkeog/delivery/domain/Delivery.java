package com.kkulkkeog.delivery.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DELIVERY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery")
    private Long no;

    private String address;

    private String message;

    private long orderNo;

    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @Enumerated(EnumType.STRING)
    private DeliveryState deliveryState;

}
