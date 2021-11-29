package org.slahsk.member.web;


import lombok.AllArgsConstructor;
import org.slahsk.member.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

}
