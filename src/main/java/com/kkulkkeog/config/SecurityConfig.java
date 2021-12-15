package com.kkulkkeog.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
        return http.authorizeExchange()
                .pathMatchers("/api/**").permitAll()
                .anyExchange().authenticated()
                .and().oauth2Login()
                .and().build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(OAuth2ClientProperties oAuth2ClientProperties) {
        List<ClientRegistration> registrations = oAuth2ClientProperties.getRegistration()
                .keySet()
                .stream()
                .map(client -> {
                    OAuth2ClientProperties.Registration registration = oAuth2ClientProperties.getRegistration().get("google");
                    return CommonOAuth2Provider
                            .GOOGLE.getBuilder(client)
                            .clientId(registration.getClientId())
                            .clientSecret(registration.getClientSecret())
                            .scope("email", "profile")
                            .build();

                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new InMemoryClientRegistrationRepository(registrations); }



//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(final ServerHttpSecurity serverHttpSecurity) {
//
//        return serverHttpSecurity
//                .csrf().disable()
//                .httpBasic().disable()
//                .formLogin().disable()
//                .authorizeExchange()
//                .pathMatchers("/api/**").authenticated()
//                .anyExchange().permitAll()
//                .and()
//                .oauth2Login(withDefaults())
//                .logout()
//                .and().exceptionHandling()
//                .accessDeniedHandler((exchange, exception) -> Mono.error(new RuntimeException("accessDeniedHandler")))
//                .and().build();
//    }
}
