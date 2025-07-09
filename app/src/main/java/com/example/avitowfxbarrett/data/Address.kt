package com.example.avitowfxbarrett.data

data class Address(
    val id: Int,
    val userId: Int,
    val city: String,
    val street: String,
    val building: String,
    val apartment: String?,
    val postalCode: String?,
    val isPrimary: Boolean = false
)