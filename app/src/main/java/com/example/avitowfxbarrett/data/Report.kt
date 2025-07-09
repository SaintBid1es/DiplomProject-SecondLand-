package com.example.avitowfxbarrett.data

import java.time.LocalDateTime

data class Report(
    val id: Int,
    val productId: Int,
    val userId: Int,
    val reportedUserId: Int,
    val reason: String,
    val status: String, // "новый", "в процессе", "решено"
    val createdAt: LocalDateTime = LocalDateTime.now()
)
