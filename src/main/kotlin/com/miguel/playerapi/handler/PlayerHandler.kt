package com.miguel.playerapi.handler

import com.miguel.playerapi.entities.Player
import com.miguel.playerapi.services.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class PlayerHandler {

    @Autowired
    private lateinit var playerService: PlayerService

    fun findAll(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playerService.findAll(), Player::class.java)
    }

    fun findById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playerService.findById(id), Player::class.java)
    }

    fun save(request: ServerRequest): Mono<ServerResponse> {
        val player = request.bodyToMono(Player::class.java)

        println(player.toString())

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(player.flatMap(playerService::save), Player::class.java))
    }
}