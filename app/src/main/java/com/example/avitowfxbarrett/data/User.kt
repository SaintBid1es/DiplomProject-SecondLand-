package com.example.avitowfxbarrett.data

import java.time.LocalDateTime

data class User(
    val id: Int,
    val name: String,
    val lastActive: LocalDateTime?,
    val verified: Boolean = false,
    val photo: String?,
    val date: LocalDateTime = LocalDateTime.now(),
    val telephone: String?,
    val email: String,
    val roleId: Int?,
    val balance: Double = 0.0,
    val isDeleted: Boolean = false
)