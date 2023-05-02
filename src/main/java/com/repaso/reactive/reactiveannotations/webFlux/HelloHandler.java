package com.repaso.reactive.reactiveannotations.webFlux;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {
    
    public Mono<ServerResponse> mostrarMensajeMono(ServerRequest serverRequest){
        return ServerResponse.ok()
            .contentType(MediaType.TEXT_PLAIN)
            .body(Mono.just("bienvenido "), String.class);
    }

    public Mono<ServerResponse> mostrarMensajeFlux(ServerRequest serverRequest){
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(Flux.just("bienvenido ", " OTRA COSA").delayElements(Duration.ofSeconds(1)).log(), String.class);
    }
}
