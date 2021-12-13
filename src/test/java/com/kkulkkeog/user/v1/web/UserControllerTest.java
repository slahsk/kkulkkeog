package com.kkulkkeog.user.v1.web;

import com.kkulkkeog.user.v1.api.web.PostUserRequest;
import com.kkulkkeog.user.v1.domain.User;
import com.kkulkkeog.user.v1.repository.UserRepository;
import com.kkulkkeog.user.v1.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = { UserController.class })
@Import(UserServiceImpl.class)
@DisplayName("사용자 web Test")
class UserControllerTest {

    @Autowired
    WebTestClient webClient;

    @MockBean
    UserRepository userRepository;


    @Test
    @DisplayName("사용자 저장 - 성공")
    void testPostUser(){
        PostUserRequest request = PostUserRequest.builder()
                        .id("khj").name("홍길동").email("test@mail.com").password("11111")
                        .build();

        User user = User.builder().userNo(1L).password("11111").email("test@mail.com").userName("홍길동").build();

        when(userRepository.save(any(User.class))).thenReturn(user);

        webClient.post()
                .uri("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request))
                .exchange()
                .expectStatus().isOk();

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("사용자 탈퇴 - 성공")
    void testDeleteUser(){
        User user = User.builder().deleted(false).email("test@mail.com").password("11111")
                        .userName("홍길동").build();


        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));


        webClient.delete()
                .uri("/api/v1/users/1")
                .exchange()
                .expectStatus().isOk();
    }


}
