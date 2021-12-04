package com.kkulkkeog.member.service;

import com.kkulkkeog.member.domain.Member;

public interface MemberService {
    Member saveMember(Member member);

    Member updateMember(Member member);

    void deleteMember(Long no);

    Member findMember(Long no);
}
