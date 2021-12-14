package com.kkulkkeog.coupon.v1.domain;

import com.kkulkkeog.coupon.v1.api.CouponIssuer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Coupon{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponNo;

    private Long shopNo;

    private String couponName;

    private String couponDescription;

    private Long minimumOrderPrice;

    private Long discountPrice;

    @Enumerated(EnumType.STRING)
    private CouponIssuer couponIssuer;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;

    public boolean isCouponAvailable(){
        LocalDateTime now = LocalDateTime.now();
        boolean after = now.isAfter(startDate);
        boolean before = now.isBefore(endDate);

        return after && before && !deleted;
    }
}
