package com.kkulkkeog.user.v1.api.web;

import com.kkulkkeog.user.v1.api.UserLoginType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetUsersRequest {
    private UserLoginType userLoginType;
}
