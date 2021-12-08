package com.kkulkkeog.coupon.domain;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon")
    private Long couponNo;

    private long memberNo;

    private long shopNo;

    private String title;

    private String message;

    private long minimumPrice;

    private long price;

    @Enumerated(EnumType.STRING)
    private CouponIssuance couponIssuance;

    @Enumerated(EnumType.STRING)
    private CouponType couponType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private boolean availableCoupon;

    private LocalDateTime usedTime;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;


    public boolean isOrderAvailableCoupon(long shopNo, long memberNo) {
        boolean result = true;

        if(!availableCoupon){
            result =  false;
        }else if(this.shopNo != shopNo){
            result =  false;
        }else if(this.memberNo != memberNo){
            result =  false;
        }

        return availableCoupon;
    }
}
