package com.kkulkkeog.member.v1.repository;

import java.util.Optional;

import com.kkulkkeog.member.v1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
