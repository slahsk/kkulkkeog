package com.kkulkkeog.shop.v1.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class PostShopRequest {
    private String shopName;

    private String shopAddress;

    private String shopMessage;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    private Integer businessNumber;
}
