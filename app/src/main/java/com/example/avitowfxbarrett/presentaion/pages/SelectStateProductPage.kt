package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avitowfxbarrett.Routes
import com.example.avitowfxbarrett.ui.theme.BlueForCard

@Composable
fun SelectStateProductPage(
    navController: NavController
){
    val scrollState = rememberScrollState()
    var checkedStateStatus by remember { mutableStateOf(false) }
    var checkedStateStatus1 by remember { mutableStateOf(false) }
    var checkedStateStatus2 by remember { mutableStateOf(false) }
    var checkedStateStatus3 by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(20.dp)
                .padding(bottom = 125.dp),

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(Routes.SelectCategory.route)
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
                Text("Сохранить и выйти", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.clickable(onClick = {
                    navController.navigate(Routes.Advertisment.route)}))

            }


            Text("Состояние", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Box {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Новое с биркой", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("Неношенная вещь · Есть бирка и ярылки\n с информацией о модели.", fontWeight = FontWeight.Bold, style = TextStyle(
                                fontSize = 12.sp, // Устанавливаем меньший размер шрифта
                                color = Color.Gray // Устанавливаем более светлый цвет
                            ))
                        }
                        Checkbox( checked = checkedStateStatus,
                            onCheckedChange = { checkedStateStatus = it })
                    }
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Отличное", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("Нет следов носки, а также потёртостей,пятне и \n других дефектов", fontWeight = FontWeight.Bold, style = TextStyle(
                                fontSize = 12.sp, // Устанавливаем меньший размер шрифта
                                color = Color.Gray // Устанавливаем более светлый цвет
                            ))
                        }
                        Checkbox( checked = checkedStateStatus1,
                            onCheckedChange = { checkedStateStatus1 = it })
                    }
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Хорошее", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("Есть небольшие дефекты. ", fontWeight = FontWeight.Bold, style = TextStyle(
                                fontSize = 12.sp, // Устанавливаем меньший размер шрифта
                                color = Color.Gray // Устанавливаем более светлый цвет
                            ))
                        }
                        Checkbox( checked = checkedStateStatus2,
                            onCheckedChange = { checkedStateStatus2 = it })
                    }
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Удовлетворительное", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("Есть заметные дефекты.", fontWeight = FontWeight.Bold, style = TextStyle(
                                fontSize = 12.sp, // Устанавливаем меньший размер шрифта
                                color = Color.Gray // Устанавливаем более светлый цвет
                            ))
                        }
                        Checkbox( checked = checkedStateStatus3,
                            onCheckedChange = { checkedStateStatus3 = it })
                    }


                }
            }
            Button(
                onClick = {
                    navController.navigate(Routes.AdType.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), colors = ButtonDefaults.buttonColors(BlueForCard)
            ) {
                Text(
                    "Продолжить",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
@Composable
@Preview
fun SelectStateProductPagePreview(){
    val navController = rememberNavController()
SelectStateProductPage(navController)
}