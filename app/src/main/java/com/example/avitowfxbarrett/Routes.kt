package com.example.avitowfxbarrett

import com.example.avitowfxbarrett.data.model.ProductModels
import com.google.gson.Gson

sealed class Routes(val route: String) {

    object Home : Routes("home")
    object Login : Routes("login")
    object Profile : Routes("profile")
    object Favorites : Routes("favorites")
    object Advertisment : Routes("advertisment")
    object Message : Routes("message")

    object ProductDetail : Routes("product_detail/{productId}") {
        fun createRoute(productId: String) = "product_detail/$productId"
    }
    object ProductDetailJSON : Routes("product_detail/{productJson}") {
        fun createRoute(product: ProductModels) = "product_detail/${Gson().toJson(product)}"
    }
}

