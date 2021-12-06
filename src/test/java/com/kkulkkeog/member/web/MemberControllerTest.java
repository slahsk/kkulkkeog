package com.kkulkkeog.member.web;

import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.repository.MemberRepository;
import com.kkulkkeog.member.api.web.PostMemberRequest;
import com.kkulkkeog.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = { MemberController.class })
@Import(MemberServiceImpl.class)
public class MemberControllerTest {

    @Autowired
    WebTestClient webClient;

    @MockBean
    MemberRepository memberRepository;


    @Test
    @DisplayName("사용자 저장")
    void testPost(){
        PostMemberRequest request = PostMemberRequest.builder()
                        .id("khj").name("홍길동").email("test@mail.com").password("11111")
                        .build();

        Member member = Member.builder().no(1L).password("11111").email("test@mail.com").name("홍길동").build();

        Mockito.when(memberRepository.save(Mockito.any(Member.class))).thenReturn(member);

        webClient.post()
                .uri("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request))
                .exchange()
                .expectStatus().isOk();

        Mockito.verify(memberRepository, Mockito.times(1)).save(Mockito.any(Member.class));
    }

    @Test
    @DisplayName("사용자 탈퇴")
    void testDelete(){
        Member member = Member.builder().memberId("khj").deleted(false).email("test@mail.com").password("11111")
                        .name("홍길동").build();


        Mockito.when(memberRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(member));


        webClient.delete()
                .uri("/api/v1/members/1")
                .exchange()
                .expectStatus().isOk();
    }


}
