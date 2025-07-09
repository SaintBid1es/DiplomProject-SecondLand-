package com.example.avitowfxbarrett

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.ui.theme.Purple40
import com.example.avitowfxbarrett.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvitoWfxbarrettTheme {
                Login()
            }
        }
    }
}

@SuppressLint("ResourceAsColor")
@Composable
fun Login() {
    val viewModel: MainViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(36.dp)

    ) {
        Text("Welcome to Back",
            color = Color.Black,
            fontSize = 20.sp
            )

        TextField(
            value = viewModel.emailText,
            onValueChange = { viewModel.emailText = it },
            label = { Text("Write to your email") }
        )

        TextField(
            value = viewModel.passwordText,
            onValueChange = { viewModel.passwordText = it },
            label = { Text("Write to your password") }
        )

        Button(
            onClick = {},
            modifier = Modifier.width(200.dp)
        ) {
            Text("Confirm")
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            Text(
                text = "Don't have account?",
                color = Purple40,
                modifier = Modifier.clickable(onClick = {

                })

            )
            Text(
                text = "Forgot password?",
                color = Purple40,
                modifier = Modifier.clickable(onClick = {

                })

            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Login()
}