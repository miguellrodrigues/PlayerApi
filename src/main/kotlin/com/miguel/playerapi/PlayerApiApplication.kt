package com.miguel.playerapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlayerApiApplication

fun main(args: Array<String>) {
    runApplication<PlayerApiApplication>(*args)
}
