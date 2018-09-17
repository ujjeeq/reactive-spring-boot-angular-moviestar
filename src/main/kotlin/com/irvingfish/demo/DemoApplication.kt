package com.irvingfish.demo

import com.irvingfish.demo.repository.ReactiveClientRegistrationMongoRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@SpringBootApplication
//@EnableReactiveMongoRepositories
@EnableWebFluxSecurity
class DemoApplication {

    @Bean
    fun init(repository: StarRepository) = CommandLineRunner {
        val stars = Flux.just("Tom Cruise", "Brad Pitt", "Tom Hanks", "Matt Damon", "George Clooney")
                .flatMap { repository.insert(Star(name = it)) }

        repository.deleteAll()
                .thenMany(stars)
                .subscribe({ println(it.name) })
    }

    @Bean
    fun initClientRegistrationRepository(clientRegistrationRepository: ReactiveClientRegistrationMongoRepository) = CommandLineRunner {
        val clientregistrations = Flux.just("hello")
                .flatMap {clientRegistrationRepository.insert(ClientRegistration.withRegistrationId("client").clientId("ddd").build())}

        clientRegistrationRepository
                .deleteAll()
                .thenMany(clientregistrations)
                .subscribe({ println(it.clientId)})
    }

}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}


class Star(
        var name: String? = null,
        @Id
        var id: String? = null,
        val email: String? = null
)

interface StarRepository : ReactiveMongoRepository<Star, String>

@Service
class StarService(private val starRepository: StarRepository) {
    fun all() = starRepository.findAll()

    fun byId(id: String) = starRepository.findById(id)

    fun save(star: Star) = starRepository.insert(star)

}





