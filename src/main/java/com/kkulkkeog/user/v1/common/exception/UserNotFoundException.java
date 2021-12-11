package com.kkulkkeog.user.v1.common.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long no) {
        super(String.format("%d 사용자를 찾을 수 없습니다.", no));
    }
}
