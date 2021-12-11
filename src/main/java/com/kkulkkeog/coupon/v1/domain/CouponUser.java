package com.kkulkkeog.coupon.v1.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_COUPON_USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class CouponUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCouponUser")
    private Long couponUserNo;

    private long userNo;

    private long couponNo;

    private boolean used;

    private LocalDateTime usedTime;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private boolean deleted;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "coupon_no")
    private Coupon coupon;
}
