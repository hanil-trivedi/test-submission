package com.maersk.containers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.maersk.containers.dto.Container;


import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings")
public class ContainerBookingController {

    @PostMapping(path = "/checkAvailable", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkAvailability(@Valid @RequestBody Container containerDetails) {

        WebClient webClient = WebClient.create();
        String responseJson = webClient.get()
                .uri("/api/checkAvailability/check", containerDetails)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bookContainer(@Valid @RequestBody Container containerDetails) {

        WebClient webClient = WebClient.create();
        String responseJson = webClient.get()
                .uri("/api/book", containerDetails)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

}
