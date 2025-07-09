package com.example.avitowfxbarrett.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.avitowfxbarrett.MainProducts
import com.example.avitowfxbarrett.data.ProductModels
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import java.lang.reflect.Modifier

@Composable
fun HomePage(navigateToProfile: (ProductModels)->Unit){
    AvitoWfxbarrettTheme{
        MainProducts(
            modifier = androidx.compose.ui.Modifier.padding(), navigateToProfile =navigateToProfile
        )
    }

}





