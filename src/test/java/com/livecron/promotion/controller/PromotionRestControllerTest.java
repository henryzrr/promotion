package com.livecron.promotion.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.DEFINED_PORT)
class PromotionRestControllerTest {

    private WebClient webClient;

    @BeforeEach
    public void before(){
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Test
    void sendBirthdayMessage() {
        Mono<String> s = webClient.get()
                .uri("/api/promocion/$birthdate")
                .retrieve()
                .bodyToMono(String.class);
        assertEquals("ok",s.block());
    }
}