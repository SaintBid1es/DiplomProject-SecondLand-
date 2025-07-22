package com.example.avitowfxbarrett.presentaion.state
//Действия которые могут делать пользователи
sealed class LoginIntent {
    data class InputEmail(val value: String): LoginIntent()
    data class InputPassword(val value: String): LoginIntent()
    object ClickButtonLogin: LoginIntent()
    object ClickButtonRegister: LoginIntent()
    object ClickButtonForgotPassword: LoginIntent()

}