package com.irvingfish.demo

import com.irvingfish.demo.repository.ReactiveClientRegistrationMongoRepository
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.stereotype.Service


@Configuration
class SecurityConfiguration(val clientRegistrationRepository: ReactiveClientRegistrationMongoRepository) {

    val clientId = "a client"

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
//        return http
          http          .authorizeExchange()
                        .matchers(EndpointRequest.toAnyEndpoint()).authenticated()
                    .anyExchange().permitAll().and()
                    .formLogin().and()
                    .httpBasic().and()
                    .oauth2Login().and()
                  .csrf().disable()
            .oauth2().client().clientRegistrationRepository(clientRegistrationRepository)

               return http.build()

    }
}

@Service
class ClientRegistrationService(private val clientRegistrationRepository: ReactiveClientRegistrationMongoRepository) {
    fun all() = clientRegistrationRepository.findAll()

    fun byId(id: String) = clientRegistrationRepository.findById(id)

    fun save(clientRegistration: ClientRegistration) = clientRegistrationRepository.insert(clientRegistration)

}