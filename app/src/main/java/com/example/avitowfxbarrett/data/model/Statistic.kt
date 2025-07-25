package com.example.avitowfxbarrett.data.model

data class Statistic(
    val id: Int,
    val viewsCount: Int = 0,
    val favoriteCount: Int = 0,
    val productId: Int?,
    val userId: Int?
)