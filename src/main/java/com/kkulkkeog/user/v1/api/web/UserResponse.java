package com.kkulkkeog.user.v1.api.web;

import com.kkulkkeog.user.v1.api.UserLoginType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class UserResponse {
    private Long userNo;

    private String email;

    private String password;

    private String userName;

    private String cellPhoneNumber;

    private UserLoginType userLoginType;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String defaultAddress;

    private Boolean deleted;



}
