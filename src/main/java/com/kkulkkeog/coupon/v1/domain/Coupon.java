package com.kkulkkeog.coupon.v1.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Coupon{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCoupon")
    private Long couponNo;

    private long memberNo;

    private long shopNo;

    private String couponName;

    private String couponDescription;

    private long minimumPrice;

    private long discountPrice;

    @Enumerated(EnumType.STRING)
    private CouponIssuance couponIssuance;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private boolean availableCoupon;

    private LocalDateTime usedTime;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private boolean deleted;


    public boolean isOrderAvailableCoupon(long shopNo, long memberNo) {
        return availableCoupon && this.shopNo == shopNo && this.memberNo == memberNo;
    }
}
