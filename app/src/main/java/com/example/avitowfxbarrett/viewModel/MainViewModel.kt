package com.example.avitowfxbarrett.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.avitowfxbarrett.Routes
import com.example.avitowfxbarrett.data.API.RetrofitClient
import com.example.avitowfxbarrett.data.model.LoginRequest
import com.example.avitowfxbarrett.data.model.LoginResponse
import com.example.avitowfxbarrett.data.model.User
import com.example.avitowfxbarrett.presentaion.state.LoginIntent
import com.example.avitowfxbarrett.presentaion.state.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow<LoginState>(LoginState.Loading)
    val state: StateFlow<LoginState> = _state
    var emailText by mutableStateOf("")
    var passwordText by mutableStateOf("")
    var currentUser by mutableStateOf<User?>(null)


    fun processIntent(intent: LoginIntent,navController: NavController,context: Context){
        when(intent){
            LoginIntent.ClickButtonLogin -> {
                try {
                    viewModelScope.launch {
                        _state.value = LoginState.Loading
                        val userList = RetrofitClient.apiService.getUsers()
                        val user = userList.find { it.email == emailText && it.password == passwordText }
                        if(user !=null){
                            _state.value = LoginState.Success(emailText,passwordText)
                        }else{
                            _state.value = LoginState.Error("User not found")
                        }
                        user?.let { foundUser ->
                            withContext(Dispatchers.Main) {

                                navController.navigate(Routes.Home.route) {
                                    currentUser = user
                                }
                            }
                        } ?: run {
                            Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    Log.e("Login", "Error during login", e)
                    Toast.makeText(context, "Login failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
            is LoginIntent.InputEmail -> {
                emailText = intent.value
            }
            is LoginIntent.InputPassword -> {
                passwordText = intent.value
            }
            LoginIntent.ClickButtonForgotPassword -> {
                navController.navigate(Routes.ForgotPassword.route)
            }
            LoginIntent.ClickButtonRegister -> {
                navController.navigate(Routes.DontHaveAccount.route)
            }
        }
    }

    init {
     _state.value = LoginState.Idle
    }


    sealed class Result<out T> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val message: String) : Result<Nothing>()
    }
}