package com.kkulkkeog.member.service;

import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.repository.MemberRepository;
import com.kkulkkeog.member.common.exception.MemberIdDuplicateException;
import com.kkulkkeog.member.common.exception.MemberNotFindException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;


    @Override
    public Mono<Member> saveMember(Member member) {
        return Mono.just(member)
        .map( m -> {
            if(memberRepository.findByMemberId(member.getMemberId()).isPresent()){
                Mono.error(new MemberIdDuplicateException(member.getMemberId()));
            }
            
            return memberRepository.save(member);
        });
    }

    @Override
    public Mono<Member> updateMember(Member member) {
        Member data = memberRepository.save(member);

        return Mono.just(data);
    }

    @Override
    public Mono<Void> deleteMember(Long no) {

        return findMember(no)
        .flatMap( member -> {
            member.delete();

            return Mono.empty();
        }).then();
    }

    @Override
    public Mono<Member> findMember(Long no) {
        Optional<Member> member = memberRepository.findById(no);

        return Mono.just(member.orElseThrow(() -> new MemberNotFindException(no)));
    }


}
