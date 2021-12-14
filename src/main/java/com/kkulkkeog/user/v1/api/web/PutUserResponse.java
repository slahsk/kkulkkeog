package com.kkulkkeog.user.v1.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PutUserResponse {

    private String userName;

    private String cellPhoneNumber;

    private String defaultAddress;
}
