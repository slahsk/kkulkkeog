package com.kkulkkeog.user.v1.common.exception;

public class UserDuplicateException extends RuntimeException{
    public UserDuplicateException(String email) {
        super(String.format("%s 이메일이 중복 되어 습니다.", email));
    }
}
