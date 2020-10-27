package com.miguel.playerapi.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class Player(
        @Id
        var id: String? = UUID.randomUUID().toString(),
        var name: String
) {}