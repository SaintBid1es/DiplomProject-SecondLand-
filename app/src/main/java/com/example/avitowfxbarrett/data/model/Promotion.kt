package com.example.avitowfxbarrett.data.model

import java.time.LocalDateTime

data class Promotion(
    val id: Int,
    val productId: Int,
    val type: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val price: Double,
    val status: String
)
