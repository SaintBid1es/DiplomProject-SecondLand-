package com.example.avitowfxbarrett.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.collections.getValue
import kotlin.collections.setValue

class DontHaveAccountViewModel: ViewModel() {
    var textName by mutableStateOf("")
    var textCode by mutableStateOf("")
    var textTelephone by mutableStateOf("")
    var textEmail by mutableStateOf("")

}