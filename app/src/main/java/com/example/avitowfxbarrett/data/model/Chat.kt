package com.example.avitowfxbarrett.data.model

import java.time.LocalDateTime

data class Chat(
    val id: Int,
    val user1Id: Int,
    val user2Id: Int,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val lastMessageId: Int?
)
