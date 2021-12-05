package com.kkulkkeog.member.api.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PutMemberResponse {

    private String email;

    private String name;
}
