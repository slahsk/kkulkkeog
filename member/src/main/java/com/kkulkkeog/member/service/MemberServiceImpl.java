package com.kkulkkeog.member.service;

import com.kkulkkeog.member.common.exception.MemberNotFindException;
import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;


    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long no) {
        Member member = findMember(no);
        member.delete();

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long no) {
        Optional<Member> member = memberRepository.findById(no);

        if(member.isEmpty()){
            throw new MemberNotFindException(no);
        }

        return member.get();
    }


}
