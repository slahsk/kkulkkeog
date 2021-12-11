package com.kkulkkeog.user.v1.repository;

import java.util.Optional;

import com.kkulkkeog.user.v1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
