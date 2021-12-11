package com.kkulkkeog.user.v1.service;

import com.kkulkkeog.user.v1.domain.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> saveUser(User member);

    Mono<User> updateUser(User member);

    Mono<Void> deleteUser(long no);

    Mono<User> findUser(long no);
}
