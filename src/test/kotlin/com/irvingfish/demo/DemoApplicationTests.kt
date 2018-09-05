package com.irvingfish.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureWebTestClient
class DemoApplicationTests {

    @Autowired
    private val client = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build()

    @Test
    fun contextLoads() {
    }

    @Test
    fun `Request HTTP API endpoint`() {
        client.get().uri("/stars").exchange()
                .expectStatus().is2xxSuccessful
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
    }

}
