package com.kkulkkeog.order.v1.domain;

import com.kkulkkeog.order.v1.api.message.PaymentType;
import lombok.*;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrder")
    private Long orderNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderMenu> orderMenus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderCoupon> orderCoupons;

    private long totalPrice;

    private long resultPrice;

    private long memberNo;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @CreatedDate
    private LocalDateTime created;




    public void calculateTotalPrice(){

    }


}
