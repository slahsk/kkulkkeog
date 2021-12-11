package com.kkulkkeog.user.v1.web;


import com.kkulkkeog.common.Constant;
import com.kkulkkeog.user.v1.api.web.UserResponse;
import com.kkulkkeog.user.v1.api.web.PostUserRequest;
import com.kkulkkeog.user.v1.api.web.PutUserRequest;
import com.kkulkkeog.user.v1.domain.User;
import com.kkulkkeog.user.v1.domain.mapper.UserMapper;
import com.kkulkkeog.user.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constant.API_V1)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public Mono<UserResponse> postUser(@RequestBody PostUserRequest postUserRequest){
        Mono<User> user = userService.saveUser(UserMapper.INSTANCE.toUser(postUserRequest));

        return user.map(UserMapper.INSTANCE::toUserResponse);
    }


    @PutMapping("/users/{userNo}")
    public Mono<UserResponse> putUser(@PathVariable Long userNo, @RequestBody PutUserRequest request){
        Mono<User> user = userService.updateUser(UserMapper.INSTANCE.toUser(userNo, request));

        return user.map(UserMapper.INSTANCE::toUserResponse);
    }

    @GetMapping("/users/{userNo}")
    public Mono<UserResponse> getUser(@PathVariable Long userNo){
        Mono<User> user = userService.findUser(userNo);

        return user.map(UserMapper.INSTANCE::toUserResponse);
    }

    @DeleteMapping("/users/{userNo}")
    public Mono<Void> deleteUser(@PathVariable Long userNo){
        return userService.deleteUser(userNo);
    }
}
