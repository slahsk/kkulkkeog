package com.kkulkkeog.member.service;

import com.kkulkkeog.member.domain.Member;
import reactor.core.publisher.Mono;

public interface MemberService {
    Mono<Member> saveMember(Member member);

    Mono<Member> updateMember(Member member);

    Mono<Void> deleteMember(Long no);

    Mono<Member> findMember(Long no);
}
