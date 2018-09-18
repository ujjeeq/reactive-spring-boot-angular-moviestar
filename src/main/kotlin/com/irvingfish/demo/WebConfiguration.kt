package com.irvingfish.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class WebConfiguration(val starService: StarService) {

    @Bean
    fun routes() = router {
        GET("/stars", {
            ServerResponse.ok().body(starService.all(), Star::class.java)
        })
        GET("/stars/{id}", {
            ServerResponse.ok().body(starService.byId(it.pathVariable("id")), Star::class.java)
        })
        POST("/stars", { request ->
            request.bodyToMono(Star::class.java).flatMap { m ->
                starService.save(m).subscribe()
                ServerResponse.status(HttpStatus.CREATED).body(BodyInserters.fromObject(m))
            }
        })
    }
}