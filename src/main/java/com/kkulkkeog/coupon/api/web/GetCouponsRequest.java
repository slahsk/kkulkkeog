package com.kkulkkeog.coupon.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class GetCouponsRequest {
    private String memberNo;
}
