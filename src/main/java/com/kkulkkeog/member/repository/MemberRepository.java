package com.kkulkkeog.member.repository;

import java.util.Optional;

import com.kkulkkeog.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberId(String memberId);
}
