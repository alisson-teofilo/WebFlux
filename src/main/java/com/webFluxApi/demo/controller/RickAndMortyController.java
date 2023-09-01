package com.webFluxApi.demo.controller;

import com.webFluxApi.demo.response.CaractereResponse;
import com.webFluxApi.demo.service.RickAndMortyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("webclient")
public class RickAndMortyController {

    RickAndMortyService rickAndMortyService;

    @GetMapping("/character/{id}")
    public Mono<CaractereResponse> getCaracterById(@PathVariable String id){
        return rickAndMortyService.findAndCaractereById(id);
    }

}
