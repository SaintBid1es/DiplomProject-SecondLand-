package com.example.avitowfxbarrett.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProductViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
):ViewModel() {

    var nameProduct by mutableStateOf(savedStateHandle["name"] ?: "")
        private set

    fun updateName(name: String) {
        nameProduct = name
        savedStateHandle["name"] = name
    }
}