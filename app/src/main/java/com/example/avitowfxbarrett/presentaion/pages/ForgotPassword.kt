package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.avitowfxbarrett.Routes
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme


@Composable
fun ForgotPass( modifier: Modifier = Modifier,navigation: NavHostController) {
    var email by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)

        ) {
            IconButton(
                onClick = {
                    navigation.navigate(Routes.Login.route){
                        popUpTo(Routes.ForgotPassword.route)
                    }
                },
                modifier = Modifier.padding()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "return on Main window")
            }
            Text(text = "Forgot Password", fontSize = 20.sp, textAlign = TextAlign.Center)
        }
        Row {
            TextField(
                value = email,
                onValueChange = {email=it},
                label = {Text("Input your email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            IconButton(
                onClick = {
                    openDialog.value = true
                }
            ) {
                Icon(Icons.Filled.Check, contentDescription = "Info on check email verification")
            }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = { openDialog.value = false},
                    title = { androidx.compose.material.Text(text = "Подтверждение Почты") },
                    text = { androidx.compose.material.Text("Введите код для завершения регистрации.") },
                    confirmButton = {
                        androidx.compose.material.Button(onClick = {
                            openDialog.value = false

                            navigation.navigate(Routes.Profile.route) {
                                popUpTo(Routes.ForgotPassword.route)
                            }
                        }) {
                            Text("Подтвердить", fontSize = 22.sp)
                        }
                        TextField(
                            value = code,
                            onValueChange = { code = it },
                            label = { Text("Input your code") }
                        )

                    },
                    dismissButton = {
                        Button(
                            onClick = { openDialog.value = false }, colors = androidx.compose.material3.ButtonDefaults.buttonColors(), border = BorderStroke(1.dp, Color.LightGray)) {
                            Text("Отмена", fontSize = 22.sp)
                        }
                    })
            }
        }
        Button(
            onClick = {
                navigation.navigate(Routes.Login.route){
                    popUpTo(Routes.ForgotPassword.route)
                }
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Confirm")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AvitoWfxbarrettTheme {
        val navController = rememberNavController()
        ForgotPass(navigation = navController)
    }
}