package com.miguel.playerapi.services.implementation

import com.miguel.playerapi.entities.Player
import com.miguel.playerapi.repositories.PlayerRepository
import com.miguel.playerapi.services.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlayerServiceImpl: PlayerService {

    @Autowired
    private lateinit var playerRepository: PlayerRepository

    override fun findAll(): Flux<Player> {
        return playerRepository.findAll()
    }

    override fun findById(id: String): Mono<Player> {
        return playerRepository.findById(id)
    }

    override fun save(player: Player): Mono<Player> {
        return playerRepository.save(player)
    }
}