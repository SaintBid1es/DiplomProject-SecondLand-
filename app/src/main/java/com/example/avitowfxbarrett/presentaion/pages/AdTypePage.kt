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
fun AdTypePage(
    navController: NavController
){
    val scrollState = rememberScrollState()
    var checkedStateViewAdvertisment by remember { mutableStateOf(false) }
    var checkedStateViewAdvertisment1 by remember { mutableStateOf(false) }
    var checkedStateViewAdvertisment2 by remember { mutableStateOf(false) }
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
                    navController.navigate(Routes.SelectStateProduct.route)
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
                Text("Сохранить и выйти", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.clickable(onClick = {
                    navController.navigate(Routes.Advertisment.route)}))

            }


            Text("Вид объявления", fontWeight = FontWeight.Bold, fontSize = 18.sp)

            Spacer(modifier = Modifier.padding(10.dp))
            Box {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Продаю своё", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                        }
                        Checkbox( checked = checkedStateViewAdvertisment,
                            onCheckedChange = { checkedStateViewAdvertisment = it })
                    }
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Товар приобретён на продажу", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                        }
                        Checkbox( checked = checkedStateViewAdvertisment1,
                            onCheckedChange = { checkedStateViewAdvertisment1 = it })
                    }
                    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Товар от производителя", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        }
                        Checkbox( checked = checkedStateViewAdvertisment2,
                            onCheckedChange = { checkedStateViewAdvertisment2 = it })
                    }



                }
            }
            Button(
                onClick = {
                    navController.navigate(Routes.InputDescriptionProduct.route)
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
fun AdTypePagePreview(){
    val navController = rememberNavController()
AdTypePage(navController)
}