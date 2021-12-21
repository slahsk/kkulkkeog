package com.kkulkkeog.coupon.v1.web;

import com.kkulkkeog.coupon.v1.domain.CouponUser;
import com.kkulkkeog.coupon.v1.service.CouponUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;
import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = { CouponUserController.class })
class CouponUserControllerTest {

    @MockBean
    CouponUserService couponUserService;

    WebTestClient webClient;

    CouponUser couponUser = null;

    @Autowired
    ApplicationContext context;


    @BeforeEach
    void setUp(){
        LocalDateTime current = LocalDateTime.now();
        couponUser = CouponUser.builder()
                .couponUserNo(1L)
                .userNo(10L)
                .couponNo(1L)
                .used(false)
                .created(current)
                .updated(current)
                .deleted(false)
                .build();

        this.webClient = WebTestClient
                .bindToApplicationContext(this.context)
                .apply(springSecurity())
                .configureClient()
                .filter(basicAuthentication())
                .build();
    }


    @Test
    @WithMockUser
    @DisplayName("사용자 쿠폰 발행 - 성공")
    void testPostCouponUser() {

        Mockito.when(couponUserService.saveCouponUser(Mockito.any(CouponUser.class))).thenReturn(Mono.just(couponUser));

        webClient
                .mutateWith(csrf())
                .post()
                .uri("/api/v1/coupons/11/users/10")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.couponUserNo").isEqualTo(1)
                .jsonPath("$.userNo").isEqualTo(10);
    }
}