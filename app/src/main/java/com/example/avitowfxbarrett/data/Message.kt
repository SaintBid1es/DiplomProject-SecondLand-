package com.example.avitowfxbarrett.data

import java.time.LocalDateTime

data class Message(
    val id: Int,
    val chatId: Int,
    val productId: Int?,
    val userId: Int,
    val text: String,
    val photo: String?,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val read: Boolean = false,
    val isDeleted: Boolean = false,
    val isEdited: Boolean = false
)
