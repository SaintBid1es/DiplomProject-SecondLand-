package com.example.avitowfxbarrett.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MessagePageViewModel : ViewModel(){

    var textSearch by  mutableStateOf("")

}