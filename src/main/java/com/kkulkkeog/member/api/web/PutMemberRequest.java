package com.kkulkkeog.member.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PutMemberRequest {
    private String email;

    private String password;

    private String name;
}
