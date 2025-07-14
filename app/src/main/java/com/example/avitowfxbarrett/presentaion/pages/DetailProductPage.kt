package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.avitowfxbarrett.data.model.ProductModels

@Composable
fun DetailProductPage(product: ProductModels){
    Text(product.title)
}
