package com.kkulkkeog.member.web;


import com.kkulkkeog.common.Constant;
import com.kkulkkeog.member.api.web.*;
import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.domain.mapper.MemberMapper;
import com.kkulkkeog.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_VERSION)
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public Mono<PostMemberResponse> postMember(@RequestBody PostMemberRequest request){
        Mono<Member> memberMono = memberService.saveMember(MemberMapper.INSTANCE.toMember(request));

        return memberMono.map(MemberMapper.INSTANCE::toPostMemberResponse);
    }


    @PutMapping("/members/{memberNo}")
    public Mono<PutMemberResponse> putMember(@PathVariable Long memberNo, @RequestBody PutMemberRequest request){
        Mono<Member> memberMono = memberService.updateMember(MemberMapper.INSTANCE.toMember(memberNo, request));

        return memberMono.map(MemberMapper.INSTANCE::toPutMemberResponse);
    }

    @GetMapping("/members/{memberNo}")
    public Mono<GetMemberResponse> getMember(@PathVariable Long memberNo){
        Mono<Member> member = memberService.findMember(memberNo);

        return member.map(MemberMapper.INSTANCE::toGetMemberResponse);
    }

    @DeleteMapping("/members/{memberNo}")
    public Mono<Void> deleteMember(@PathVariable Long memberNo){
        return memberService.deleteMember(memberNo);
    }
}
