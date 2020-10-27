package com.miguel.playerapi.services

import com.miguel.playerapi.entities.Player
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PlayerService {

    fun findAll(): Flux<Player>

    fun findById(id: String): Mono<Player>

    fun save(player: Player): Mono<Player>
}