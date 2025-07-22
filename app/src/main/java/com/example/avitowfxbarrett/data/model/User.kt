package com.example.avitowfxbarrett.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class User(
    val id: Int,
    val name: String,
    val password: String,
    val lastActive: LocalDateTime?,
    val verified: Boolean = false,
    val photo: String?,
    @SerializedName("date")
    val date: String = LocalDateTime.now().toString(),
    val telephone: String?,
    val email: String,
    val roleId: Int?,
    val balance: Double = 0.0,
    val isDeleted: Boolean = false
)
data class LoginRequest(val email: String, val password: String)

data class LoginResponse(
    @SerializedName("token")
    val token: String,

    val refreshToken: String?,
    val expiresIn: Int?
)