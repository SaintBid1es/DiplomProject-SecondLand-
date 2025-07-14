package com.example.avitowfxbarrett.data.model

object FavoriteProvider {
    val favorite = Favorite(
        id = 1,
        userId = 1,
        productId = 1
    )
    val favoriteList = listOf(
        favorite,
        Favorite(
            id = 2,
            userId = 2,
            productId = 2
        ),
        Favorite(
            id = 3,
            userId = 1,
            productId = 3
        ),
        Favorite(
            id = 4,
            userId = 1,
            productId = 1
        ),

    )
}