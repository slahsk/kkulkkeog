package com.kkulkkeog.member.v1.service;

import com.kkulkkeog.member.v1.domain.Member;
import com.kkulkkeog.member.v1.repository.MemberRepository;
import com.kkulkkeog.member.v1.common.exception.MemberDuplicateException;
import com.kkulkkeog.member.v1.common.exception.MemberNotFoundException;

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
            if(memberRepository.findByEmail(m.getEmail()).isPresent()){
               throw new MemberDuplicateException(m.getEmail());
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
    public Mono<Void> deleteMember(long no) {
        return findMember(no)
        .doOnNext( member -> {
            member.setDeleted(true);
        }).then();
    }

    @Override
    public Mono<Member> findMember(long no) {
        Optional<Member> member = memberRepository.findById(no);

        return Mono.just(member.orElseThrow(() -> new MemberNotFoundException(no)));
    }


}
