package com.kkulkkeog.member.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostMemberResponse {
    private Long no;

    private String email;

    private String id;

    private String name;
}
