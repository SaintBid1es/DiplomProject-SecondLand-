package com.example.avitowfxbarrett.data

import com.example.avitowfxbarrett.R

object CategoryProvider {
    val category = Category(
        id = 1,
        title = "Авто",
        imageId = R.drawable.avto
    )
    val categoryList = listOf(
        category,
        Category(
            id = 2,
            title = "Недвижимость",
            imageId = R.drawable.apartments
        ),
        Category(
            id = 3,
            title = "Услуги",
            imageId = R.drawable.service
        ),
        Category(
            id = 4,
            title = "Техника",
            imageId = R.drawable.iphone
        ),

    )
}