package com.miguel.playerapi.repositories

import com.miguel.playerapi.entities.Player
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PlayerRepository: ReactiveMongoRepository<Player, String> {
}