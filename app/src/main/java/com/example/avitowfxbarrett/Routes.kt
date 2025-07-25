package com.example.avitowfxbarrett

import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.User
import com.google.gson.Gson

sealed class Routes(val route: String) {

    object Home : Routes("home")
    object Login : Routes("login")
    object Profile : Routes("profile")
    object Favorites : Routes("favorites")
    object Advertisment : Routes("advertisment")
    object Message : Routes("message")
    object ForgotPassword : Routes("forgotPassword")
    object DontHaveAccount : Routes("dontHaveAccount")
    object AddProduct : Routes("AddProduct")
    object AdType : Routes("AdType")
    object IndicateNameProduct : Routes("IndicateNameProduct")
    object InputDescriptionProduct : Routes("InputDescriptionProduct")
    object SelectAddresForProduct : Routes("SelectAddresForProduct")
    object SelectCategory : Routes("SelectCategory")
    object SelectStateProduct : Routes("SelectStateProduct")
    object TermsOfPage : Routes("TermsOfPage")


    object ProductDetail : Routes("product_detail/{productId}") {
        fun createRoute(productId: String) = "product_detail/$productId"
    }
    object ProductDetailJSON : Routes("product_detail/{productJson}") {
        fun createRoute(product: ProductModels) = "product_detail/${Gson().toJson(product)}"
    }
    object UserJSON : Routes("user/{userJson}") {
        fun createRoute(user: User) = "user/${Gson().toJson(user)}"
    }
}

