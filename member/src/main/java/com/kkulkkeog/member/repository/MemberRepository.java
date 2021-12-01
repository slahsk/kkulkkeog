package com.kkulkkeog.member.repository;

import com.kkulkkeog.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
