package com.example.avitowfxbarrett.presentaion.state

import com.example.avitowfxbarrett.data.model.Message
import com.example.avitowfxbarrett.data.model.ProductModels

sealed class FavoriteState{
    object Loading: FavoriteState()

    data class Success(
        val favorites: List<ProductModels>
    ): FavoriteState()

    data class Error(
        val message: String
    ): FavoriteState()
}