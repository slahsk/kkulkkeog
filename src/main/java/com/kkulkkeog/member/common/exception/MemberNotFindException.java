package com.kkulkkeog.member.common.exception;

public class MemberNotFindException extends RuntimeException{
    public MemberNotFindException(Long no) {
        super(String.format("MemberNotFind no: %d", no));
    }
}
