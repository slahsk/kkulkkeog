package com.kkulkkeog.user.v1.service;

import com.kkulkkeog.review.v1.common.exception.ReviewNotFoundException;
import com.kkulkkeog.user.v1.domain.User;
import com.kkulkkeog.user.v1.repository.UserRepository;
import com.kkulkkeog.user.v1.common.exception.UserDuplicateException;
import com.kkulkkeog.user.v1.common.exception.UserNotFoundException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository memberRepository;


    @Override
    public Mono<User> saveUser(User member) {
        return Mono.just(member)
        .map( m -> {
            if(memberRepository.findByEmail(m.getEmail()).isPresent()){
               throw new UserDuplicateException(m.getEmail());
            }

            return memberRepository.save(member);
        });
    }

    @Override
    public Mono<User> updateUser(User member) {
        User data = memberRepository.save(member);

        return Mono.just(data);
    }

    @Override
    public Mono<Void> deleteUser(long no) {
        return findUser(no)
        .doOnNext( member -> {
            member.setDeleted(true);
        }).then();
    }

    @Override
    public Mono<User> findUser(long no) {
        return Mono.just(memberRepository.findById(no).orElseThrow( () -> new UserNotFoundException(no)));
    }

    @Override
    public Mono<User> findUserByEmail(String email) {
        return Mono.just(email)
                .map(s -> memberRepository.findByEmail(s))
                .map(user ->{
                    log.debug("findUserByEmail: {}", user);
                   return user.orElseThrow( () -> new UserNotFoundException(email));
                });
    }

    @Override
    public Mono<Page<User>> findAllUsers(Example<User> example, Pageable pageable) {
        return Mono.just(memberRepository.findAll(example, pageable));
    }


}
