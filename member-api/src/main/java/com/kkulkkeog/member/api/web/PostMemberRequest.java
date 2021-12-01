package com.kkulkkeog.member.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostMemberRequest {

    private String email;

    private String id;

    private String password;

    private String name;
}
