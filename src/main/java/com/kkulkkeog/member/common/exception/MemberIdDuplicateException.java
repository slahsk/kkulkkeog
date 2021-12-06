package com.kkulkkeog.member.common.exception;

public class MemberIdDuplicateException extends RuntimeException{
    public MemberIdDuplicateException(String memberId) {
        super(String.format("MemberIdDuplicate memberId: %s", memberId));
    }
}
