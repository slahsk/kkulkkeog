package com.kkulkkeog.coupon.v1.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class CouponUserResponse {

    private Long couponUserNo;

    private long userNo;

    private boolean used;

    private LocalDateTime usedTime;

    private LocalDateTime created;

    private LocalDateTime updated;
}
