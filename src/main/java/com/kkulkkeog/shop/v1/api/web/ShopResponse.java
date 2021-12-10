package com.kkulkkeog.shop.v1.api.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ShopResponse {

    private long shopNo;

    private String shopName;

    private String shopAddress;

    private String shopMessage;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    private LocalDateTime created;

    private LocalDateTime updated;

    private boolean deleted;
}
