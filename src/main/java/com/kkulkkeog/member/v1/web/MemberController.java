package com.kkulkkeog.member.v1.web;


import com.kkulkkeog.common.Constant;
import com.kkulkkeog.member.v1.api.web.MemberResponse;
import com.kkulkkeog.member.v1.api.web.PostMemberRequest;
import com.kkulkkeog.member.v1.api.web.PutMemberRequest;
import com.kkulkkeog.member.v1.domain.Member;
import com.kkulkkeog.member.v1.domain.mapper.MemberMapper;
import com.kkulkkeog.member.v1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constant.API_V1)
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public Mono<MemberResponse> postMember(@RequestBody PostMemberRequest request){
        Mono<Member> memberMono = memberService.saveMember(MemberMapper.INSTANCE.toMember(request));

        return memberMono.map(MemberMapper.INSTANCE::toMemberResponse);
    }


    @PutMapping("/members/{memberNo}")
    public Mono<MemberResponse> putMember(@PathVariable Long memberNo, @RequestBody PutMemberRequest request){
        Mono<Member> memberMono = memberService.updateMember(MemberMapper.INSTANCE.toMember(memberNo, request));

        return memberMono.map(MemberMapper.INSTANCE::toMemberResponse);
    }

    @GetMapping("/members/{memberNo}")
    public Mono<MemberResponse> getMember(@PathVariable Long memberNo){
        Mono<Member> member = memberService.findMember(memberNo);

        return member.map(MemberMapper.INSTANCE::toMemberResponse);
    }

    @DeleteMapping("/members/{memberNo}")
    public Mono<Void> deleteMember(@PathVariable Long memberNo){
        return memberService.deleteMember(memberNo);
    }
}
