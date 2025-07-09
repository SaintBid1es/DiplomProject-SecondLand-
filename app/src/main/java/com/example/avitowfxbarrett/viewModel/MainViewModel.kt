package com.example.avitowfxbarrett.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var emailText by mutableStateOf("")
    var passwordText by mutableStateOf("")
}