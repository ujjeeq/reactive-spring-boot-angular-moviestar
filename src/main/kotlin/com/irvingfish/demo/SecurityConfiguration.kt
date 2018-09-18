package com.irvingfish.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
class SecurityConfiguration() {

    val clientRegistration = ClientRegistration.withRegistrationId("registration-1")
            .clientId("client-1")
            .clientSecret("secret")
            .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUriTemplate("https://client.com/callback/client-1")
            .scope("read", "write")
            .authorizationUri("https://provider.com/oauth2/authorize")
            .tokenUri("https://localhost:8080/oauth2/token")
            .userInfoUri("https://provider.com/user")
            .userNameAttributeName("id")
            .clientName("client-1")
            .build()!!

    @Bean
    fun repository(): ReactiveClientRegistrationRepository {
        return InMemoryReactiveClientRegistrationRepository(clientRegistration)
    }

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity, clientRegistrationRepository: ReactiveClientRegistrationRepository): SecurityWebFilterChain {
        http.authorizeExchange()
                .matchers(EndpointRequest.toAnyEndpoint()).authenticated()
                .anyExchange().permitAll().and()
                .formLogin().and()
                .httpBasic().and()
                .oauth2Login().and()
                .csrf().disable()
                .oauth2Client().clientRegistrationRepository(clientRegistrationRepository)

        return http.build()

    }
}

