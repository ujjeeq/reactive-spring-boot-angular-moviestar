package com.irvingfish.demo

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DemoApplicationTests {

    @Autowired
    private val client = WebTestClient.bindToServer().build()

    @Test
    fun `(Test A) Request HTTP API endpoint`() {
        client.get().uri("/stars").exchange()
                .expectStatus().is2xxSuccessful
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .expectBodyList(Star::class.java).hasSize(5)
    }



    @Test
    fun `(Test B) Post HTTP API endpoint`() {
        val mockStar = "a mock star"
        val starMono = Mono.just(Star(mockStar))
        client.post().uri("/stars")
                .contentType(MediaType.APPLICATION_JSON)
                .body(starMono,Star::class.java)
                .exchange()
                .expectStatus().isCreated
                .expectBody().jsonPath("$.name").isEqualTo(mockStar)
    }

}
