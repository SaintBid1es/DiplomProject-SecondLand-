package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avitowfxbarrett.R
import com.example.avitowfxbarrett.Routes
import com.example.avitowfxbarrett.ui.theme.BlueForCard

@Composable
fun AddProductPage(
    navController: NavController
){

    val scrollState = rememberScrollState()
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
            modifier = Modifier.fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(Routes.Advertisment.route){
                popUpTo(Routes.AddProduct.route)
            }
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
                Text("Создание объявления", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            }
            Text("Внешний вид:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            IconButton(onClick = {

            }, modifier = Modifier.size(90.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray)) {
                Icon(painter = painterResource(R.drawable.camera_ic), contentDescription = "",
                    modifier = Modifier
                        .size(25.dp))
            }
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.IndicateNameProduct.route)
                },
                modifier = Modifier
                    .offset(y = (500).dp)
                    .fillMaxWidth()
                    .padding(10.dp)
                , backgroundColor =  (BlueForCard)
            ) {
                androidx.compose.material3.Text(
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
fun AddProductPagePreview(){
    val navigation = rememberNavController()
    AddProductPage(navigation)
}