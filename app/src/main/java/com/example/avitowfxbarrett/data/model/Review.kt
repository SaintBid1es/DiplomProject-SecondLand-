package com.example.avitowfxbarrett.data.model

data class Review(
    val id: Int,
    val rating: Int, // 1-5
    val userId: Int,
    val name: String?,
    val description: String?
)