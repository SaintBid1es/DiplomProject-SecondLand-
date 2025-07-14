package com.example.avitowfxbarrett.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.avitowfxbarrett.data.model.ProductModels

class ProductsMainViewModel(): ViewModel(){
    var textSearch by mutableStateOf("")
    private val _favorites = mutableStateMapOf<Int, Boolean>()

    fun changeFavorite(product: ProductModels) {
        // Инвертируем текущее состояние
        _favorites[product.id] = !(_favorites[product.id] ?: product.isFavorite)
    }

    fun isFavorite(product: ProductModels): Boolean {
        return _favorites[product.id] ?: product.isFavorite
    }

}