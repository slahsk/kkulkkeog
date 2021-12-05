package com.kkulkkeog.coupon.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_COUPON")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon")
    private Long no;

    private String title;

    private String message;

    private long maxPrice;

    private int percent;

    private int price;

    @Enumerated(EnumType.STRING)
    private CouponIssuance couponIssuance;

    @Enumerated(EnumType.STRING)
    private CouponType couponType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private boolean duplicatePossible;
}
