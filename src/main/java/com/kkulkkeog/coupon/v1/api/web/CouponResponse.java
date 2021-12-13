package com.kkulkkeog.coupon.v1.api.web;

import com.kkulkkeog.coupon.v1.domain.CouponIssuer;
import com.kkulkkeog.coupon.v1.domain.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class CouponResponse {

    private Long couponNo;

    private Long shopNo;

    private String couponName;

    private String couponDescription;

    private Long minimumOrderPrice;

    private Long discountPrice;

    private CouponIssuer couponIssuer;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Boolean deleted;
}
