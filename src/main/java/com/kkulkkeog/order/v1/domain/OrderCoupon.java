package com.kkulkkeog.order.v1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORDER_COUPON")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"order"})
public class OrderCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCouponNo;

    private long memberNo;

    private long shopNo;


    @ManyToOne
    @JoinColumn(name = "order_no")
    private Order order;
}
