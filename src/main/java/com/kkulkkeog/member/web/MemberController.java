package com.kkulkkeog.member.web;


import com.kkulkkeog.member.api.web.GetMemberResponse;
import com.kkulkkeog.member.api.web.PostMemberRequest;
import com.kkulkkeog.member.api.web.PostMemberResponse;
import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.domain.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import com.kkulkkeog.member.service.MemberService;
import org.springframework.web.bind.annotation.*;
import reactor.netty.http.server.HttpServerResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
    private MemberService memberService;

    @PostMapping("/members")
    public PostMemberResponse postMember(PostMemberRequest request){
        Member member = memberService.saveMember(MemberMapper.INSTANCE.toMember(request));

        return MemberMapper.INSTANCE.toPostMemberResponse(member);
    }

    @GetMapping("/members/{no}")
    public GetMemberResponse getMember(@PathVariable Long no){
        Member member = memberService.findMember(no);

        return MemberMapper.INSTANCE.toGetMemberResponse(member);
    }

    @DeleteMapping("/members/{no}")
    public void deleteMember(@PathVariable Long no){
        memberService.deleteMember(no);

    }
}
