package com.kkulkkeog.member.v1.common.exception;

public class MemberDuplicateException extends RuntimeException{
    public MemberDuplicateException(String email) {
        super(String.format("%s 이메일이 중복 되어 씁니다.", email));
    }
}
