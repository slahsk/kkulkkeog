package com.kkulkkeog.user.v1.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PutUserRequest {
    private String email;

    private String password;

    private String userName;

    private String cellPhoneNumber;

    private String defaultAddress;
}
