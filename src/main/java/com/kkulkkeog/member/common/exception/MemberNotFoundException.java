package com.kkulkkeog.member.common.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Long no) {
        super(String.format("MemberNotFind no: %d", no));
    }
}
