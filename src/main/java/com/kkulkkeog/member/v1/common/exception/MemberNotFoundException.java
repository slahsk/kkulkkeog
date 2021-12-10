package com.kkulkkeog.member.v1.common.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Long no) {
        super(String.format("MemberNotFind no: %d", no));
    }
}
