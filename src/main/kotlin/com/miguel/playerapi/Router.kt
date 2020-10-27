package com.miguel.playerapi

import com.miguel.playerapi.handler.PlayerHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class Router {

    @Bean
    fun route(handler: PlayerHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
                .route(RequestPredicates.GET("/players").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), HandlerFunction { request: ServerRequest? -> handler.findAll(request!!) })
                .andRoute(RequestPredicates.GET("/players/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), HandlerFunction { request: ServerRequest? -> handler.findById(request!!) })
                .andRoute(RequestPredicates.POST("/players").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), HandlerFunction { request: ServerRequest? -> handler.save(request!!) })
    }
}