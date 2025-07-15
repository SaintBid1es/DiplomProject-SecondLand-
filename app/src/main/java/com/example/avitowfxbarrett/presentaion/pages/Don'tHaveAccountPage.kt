package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.avitowfxbarrett.Routes
import com.example.avitowfxbarrett.viewModel.DontHaveAccountViewModel

@Composable
fun DontHaveAccountPage(
    navigation: NavHostController,
    viewModel: DontHaveAccountViewModel = viewModel()
) {
    val openDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navigation.navigate(Routes.Login.route) {
                        popUpTo(Routes.DontHaveAccount.route)
                    }
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
            }
            Text(text = "Регистрация аккаунта", fontSize = 20.sp)
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            horizontalAlignment = Alignment.Start

        ) {
            Text("Имя", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp), fontWeight = FontWeight.Bold)
            TextField(
                value = viewModel.textName,
                onValueChange = { viewModel.textName = it },
                label = { Text("Введите Имя ") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    backgroundColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth() .padding(start = 0.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Text("Почта", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp), fontWeight = FontWeight.Bold)
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                TextField(
                    value = viewModel.textEmail,
                    onValueChange = { viewModel.textEmail = it },
                    label = { Text("Введите Почту ") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        backgroundColor = Color.Transparent
                    ),

                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                IconButton(onClick = {
                    openDialog.value = true
                }) {
                    Icon(Icons.Filled.Check, contentDescription = "")
                }
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog.value = false},
                        title = { Text(text = "Подтверждение Почты") },
                        text = { Text("Введите код для завершения регистрации.") },
                        confirmButton = {
                            Button(onClick = {
                                openDialog.value = false

                            navigation.navigate(Routes.Profile.route){
                                popUpTo(Routes.DontHaveAccount.route)
                            }}) {
                                Text("Подтвердить", fontSize = 22.sp)
                            }
                            TextField(
                                value = viewModel.textCode,
                                onValueChange = { viewModel.textCode = it },
                                label = { Text("Input your code") }
                            )

                        },
                        dismissButton = {
                            Button(
                                onClick = { openDialog.value = false }, colors = ButtonDefaults.buttonColors(), border = BorderStroke(1.dp, Color.LightGray)) {
                                Text("Отмена", fontSize = 22.sp)
                            }
                        })
                }

            }
            Text("Номер телефона", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp), fontWeight = FontWeight.Bold)
            TextField(
                value = viewModel.textTelephone,
                onValueChange = { viewModel.textTelephone = it },
                label = { Text("Введите номер телефона ") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    backgroundColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth() .padding(start = 0.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )
            Button(onClick = {
                    navigation.navigate(Routes.Profile.route)
            }, modifier = Modifier.fillMaxWidth()
                .padding(15.dp)) {
                Text("Подтвердить")
            }


        }
    }
}

@Composable
@Preview
fun DontHaveAccountPagePreview() {
    val navController = rememberNavController()
    DontHaveAccountPage(navController)
}
