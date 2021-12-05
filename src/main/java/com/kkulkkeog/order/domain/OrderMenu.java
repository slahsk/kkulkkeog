package com.kkulkkeog.order.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORDER_MENU")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"order"})
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderMenu")
    private Long no;

    private long menuNo;

    private long price;

    @ManyToOne
    @JoinColumn(name = "order_no")
    private Order order;

}
