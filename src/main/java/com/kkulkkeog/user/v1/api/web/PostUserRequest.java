package com.kkulkkeog.user.v1.api.web;

import com.kkulkkeog.user.v1.api.UserLoginType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostUserRequest {
    private String email;

    private String password;

    private String userName;

    private String cellPhoneNumber;

    private String defaultAddress;

    private UserLoginType userLoginType;
}
