package com.kkulkkeog.user.v1.service;

import com.kkulkkeog.user.v1.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> saveUser(User member);

    Mono<User> updateUser(User member);

    Mono<Void> deleteUser(long no);

    Mono<User> findUser(long no);

    Mono<User> findUserByEmail(String email);

    Mono<Page<User>> findAllUsers(Example<User> example, Pageable pageable);
}
