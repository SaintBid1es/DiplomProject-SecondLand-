package com.example.avitowfxbarrett.viewModel

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.avitowfxbarrett.data.ProductModels
import kotlin.collections.set

class FavoriteViewModel : ViewModel(){

    val _favorite = mutableStateMapOf<Int, Boolean>()

    fun changeFavorite(productModels: ProductModels){
        _favorite[productModels.id] = !(_favorite[productModels.id] ?: productModels.isFavorite)
    }
    fun isFavorite(productModels: ProductModels): Boolean{
        return _favorite[productModels.id] ?: productModels.isFavorite
    }

}