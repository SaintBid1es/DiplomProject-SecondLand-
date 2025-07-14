package com.example.avitowfxbarrett.data.model

import com.example.avitowfxbarrett.R

object ProductProvider {
    val product = ProductModels(
        id = 1,
        title = "Ламборгини",
        imageId = R.drawable.lamba,
        isFavorite = true,
        location = "м.Шелепиха",
        cost = 600000.0,
        time = "13:32"
    )
    val productList = listOf(
        product,
        ProductModels(
            id = 2,
            title = "Аниме фигурка",
            imageId = R.drawable.anime,
            isFavorite = false,
            location = null,
            cost = 1500.0,
            time = "13:32"
        ),
        ProductModels(
            id = 3,
            title = "Компьютер",
            imageId = R.drawable.comp,
            isFavorite = false,
            location = "м.Юго-западная",
            cost = 35000.0,
            time = "13:32"
        ),
        ProductModels(
            id = 4,
            title = "Гитара",
            imageId = R.drawable.guitar,
            isFavorite = true,
            location = null,
            cost = 5000.0,
            time = "13:32"
        ),
        ProductModels(
            id = 4,
            title = "Гитара",
            imageId = R.drawable.guitar,
            isFavorite = true,
            location = null,
            cost = 5000.0,
            time = "13:32"
        ),

        )
}