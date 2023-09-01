package com.webFluxApi.demo.service;

import com.webFluxApi.demo.response.CaractereResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyService {
    private final WebClient webClient;

    public RickAndMortyService(WebClient.Builder builder) {
        webClient = WebClient.builder().baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CaractereResponse> findAndCaractereById(String id){
        log.info("Testando o personagem do id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros")))
                .bodyToMono(CaractereResponse.class);
    }

}
