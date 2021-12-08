package com.kkulkkeog.member.api.web;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetMemberResponse {
    private Long no;

    private String email;

    private String id;

    private String name;

    private List<Address> addresses;


    @Getter
    @Builder
    public static class Address {
        private String title;

        private String memberAddress;

        private String message;

        private int phoneNumber;
    }
}
