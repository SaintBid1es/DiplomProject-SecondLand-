package com.example.avitowfxbarrett.presentaion.state

sealed class LoginState {
    object Loading: LoginState()
    object Idle: LoginState()
    data class Success(val email:String,val password: String) : LoginState()
    data class Error(
        val message: String
    ): LoginState()
}