package com.kkulkkeog.order.domain;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderCoupon")
    private Long no;


    @ManyToOne
    @JoinColumn(name = "order_no")
    private Order order;
}