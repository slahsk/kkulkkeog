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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponUserNo;

    private Long userNo;

    private Long couponNo;

    private Boolean used;

    private LocalDateTime usedTime;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "couponNo", insertable = false, updatable = false)
    private Coupon coupon;
}
