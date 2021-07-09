package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@RestController
public class ClientController {

    private final WebClient webClient;

    public ClientController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/greet")
    public String greet() {
        return this.webClient
                .get()
//                .uri("/message")
//                .attributes(clientRegistrationId("client1"))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
