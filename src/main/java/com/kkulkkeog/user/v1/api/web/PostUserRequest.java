package com.kkulkkeog.user.v1.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUserRequest {

    private String email;

    private String id;

    private String password;

    private String name;
}
