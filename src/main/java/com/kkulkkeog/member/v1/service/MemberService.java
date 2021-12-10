package com.kkulkkeog.member.v1.service;

import com.kkulkkeog.member.v1.domain.Member;
import reactor.core.publisher.Mono;

public interface MemberService {
    Mono<Member> saveMember(Member member);

    Mono<Member> updateMember(Member member);

    Mono<Void> deleteMember(long no);

    Mono<Member> findMember(long no);
}
