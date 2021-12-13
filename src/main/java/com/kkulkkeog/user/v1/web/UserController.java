package com.kkulkkeog.user.v1.web;


import com.kkulkkeog.common.Constant;
import com.kkulkkeog.review.v1.api.web.GetReviewRequest;
import com.kkulkkeog.review.v1.api.web.ReviewResponse;
import com.kkulkkeog.review.v1.domain.Review;
import com.kkulkkeog.review.v1.domain.mapper.ReviewMapper;
import com.kkulkkeog.user.v1.api.web.GetUsersRequest;
import com.kkulkkeog.user.v1.api.web.UserResponse;
import com.kkulkkeog.user.v1.api.web.PostUserRequest;
import com.kkulkkeog.user.v1.api.web.PutUserRequest;
import com.kkulkkeog.user.v1.domain.User;
import com.kkulkkeog.user.v1.domain.mapper.UserMapper;
import com.kkulkkeog.user.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constant.API_V1)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    public Mono<Page<UserResponse>> getUsers(GetUsersRequest getUsersRequest, Pageable pageable){
        User user = UserMapper.INSTANCE.toUser(getUsersRequest);

        Mono<Page<User>> userPage = userService.findAllUsers(Example.of(user), pageable);

        return userPage.map(r -> r.map(UserMapper.INSTANCE::toUserResponse));
    }

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
