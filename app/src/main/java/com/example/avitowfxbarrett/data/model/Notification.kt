package com.example.avitowfxbarrett.data.model

import java.time.LocalDateTime

data class Notification(
    val id: Int,
    val userId: Int,
    val type: String, // "message", "sale", "promotion"
    val content: String,
    val isRead: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
)