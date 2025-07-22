package com.example.avitowfxbarrett.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.presentaion.state.FavoriteIntent
import com.example.avitowfxbarrett.presentaion.state.FavoriteState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.collections.set

class FavoriteViewModel : ViewModel() {

    private val _state = MutableStateFlow<FavoriteState>(FavoriteState.Loading)
    val state: StateFlow<FavoriteState> = _state
    val _favorites = mutableStateMapOf<Int, Boolean>()

    init {
        _state.value = FavoriteState.Success(ProductProvider.productList.filter { it.isFavorite })
    }


    fun isFavorite(productModels: ProductModels): Boolean {
        return _favorites[productModels.id] ?: productModels.isFavorite
    }

    fun processIntent(intent: FavoriteIntent, product: ProductModels) {
        when (intent) {
            FavoriteIntent.ChangeFavorite -> {
                val newStatus = !isFavorite(product)
                _favorites[product.id] = newStatus

                // Обновляем состояние
                val current = (_state.value as? FavoriteState.Success)?.favorites ?: emptyList()
                val updatedList = if (newStatus) {
                    current + product.copy(isFavorite = true)
                } else {
                    current.filterNot { it.id == product.id }
                }

                _state.value = FavoriteState.Success(updatedList)
            }
        }
    }
}