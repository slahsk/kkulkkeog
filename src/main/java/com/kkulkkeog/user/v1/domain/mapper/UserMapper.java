package com.kkulkkeog.user.v1.domain.mapper;

import com.kkulkkeog.user.v1.api.web.GetUsersRequest;
import com.kkulkkeog.user.v1.api.web.PutUserRequest;
import com.kkulkkeog.user.v1.api.web.UserResponse;
import com.kkulkkeog.user.v1.api.web.PostUserRequest;
import com.kkulkkeog.user.v1.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(PostUserRequest postUserRequest);

    User toUser(Long no, PutUserRequest request);

    UserResponse toUserResponse(User member);

    User toUser(GetUsersRequest getUsersRequest);
}
