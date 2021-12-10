package com.kkulkkeog.member.web;


import com.kkulkkeog.common.Constant;
import com.kkulkkeog.member.api.web.MemberResponse;
import com.kkulkkeog.member.api.web.PostMemberRequest;
import com.kkulkkeog.member.api.web.PutMemberRequest;
import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.domain.mapper.MemberMapper;
import com.kkulkkeog.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Constant.API_VERSION)
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
