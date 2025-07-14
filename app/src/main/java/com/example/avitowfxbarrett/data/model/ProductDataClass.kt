package com.example.avitowfxbarrett.data.model

import java.io.Serializable
import java.time.LocalDateTime

data class ProductModels(
    val id: Int,
    val imageId: Int,
    val title: String,
    val cost:Double,
    var isFavorite: Boolean,
    val location: String?,
    val time: String?
) : Serializable
data class Product(
    val id: Int,
    val name: String,
    val description: String?,
    val typeId: Int?,
    val categoryId: Int?,
    val date: LocalDateTime = LocalDateTime.now(),
    val attachmentId: Int?,
    val stateProduct: String, // "новое" or "бу"
    val offer: String?,
    val price: Double,
    val addressId: Int?,
    val delivery: Boolean = false,
    val onlineShow: Boolean = false,
    val autopublish: Boolean = false,
    val userId: Int,
    val statisticId: Int?,
    val stateSale: Boolean = false,
    val stateAnnouncement: String, // "активное", "черновики", "архив"
    val isDeleted: Boolean = false
)
