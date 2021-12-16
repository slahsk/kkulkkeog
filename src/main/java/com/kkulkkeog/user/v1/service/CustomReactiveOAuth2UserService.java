package com.kkulkkeog.user.v1.service;

import com.kkulkkeog.user.v1.common.exception.UserNotFoundException;
import com.kkulkkeog.user.v1.domain.OAuthAttributes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.ReactiveOAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomReactiveOAuth2UserService implements ReactiveOAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserService userService;

    @Override
    public Mono<OAuth2User> loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.debug("getAccessToken: {}",userRequest.getAccessToken());
        log.debug("getAdditionalParameters: {}",userRequest.getAdditionalParameters());
        log.debug("getClientRegistration: {}",userRequest.getClientRegistration());


        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());


       return userService.findUserByEmail(attributes.getEmail())
                .onErrorResume(UserNotFoundException.class, e -> {
                    log.debug("UserNotFoundException: {}", e);

                    return Mono.just(attributes.toUser());
                })
               .flatMap(userService::saveUser)
               .map(user ->new DefaultOAuth2User(
                        Collections.singleton(new SimpleGrantedAuthority(user.getUserRole().getRole())),
                        attributes.getAttributes(),
                        attributes.getNameAttributeKey())
               );

    }
}
