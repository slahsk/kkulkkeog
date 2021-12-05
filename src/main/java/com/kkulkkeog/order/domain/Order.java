package com.kkulkkeog.order.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_ORDER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order")
    private Long no;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderMenu> orderMenus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderCoupon> orderCoupons;

    private long totalPrice;

    private long memberCouponNo;

    private long couponNo;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;


    private LocalDateTime created;

}
