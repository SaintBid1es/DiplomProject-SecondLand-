package com.example.avitowfxbarrett.data.model

import java.time.LocalDateTime

data class PriceHistory(
    val id: Int,
    val productId: Int,
    val oldPrice: Double,
    val newPrice: Double,
    val changeDate: LocalDateTime = LocalDateTime.now()
)