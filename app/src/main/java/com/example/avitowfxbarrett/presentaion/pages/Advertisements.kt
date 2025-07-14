package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.presentaion.listItem.AdvertismentListItem
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.ui.theme.BlueForCard


@Composable
fun AdvertisementsPage(){
    AvitoWfxbarrettTheme{
        val favorites = remember { ProductProvider.productList }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .background(Color.White)
                ,
            verticalArrangement = Arrangement.spacedBy(10.dp)

        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Мои объявления",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
            }
            Card (
                modifier = Modifier
                    .padding(start = 30.dp,end = 30.dp)
                    .height(100.dp)
                    .width(400.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = BlueForCard
                    )
            ) {
                Text(text = "1800 P", fontWeight = FontWeight.Bold, fontSize = 30.sp, modifier = Modifier.padding(start = 20.dp, top = 10.dp))
                Text(text = "принесли продажи на Авито", fontSize = 22.sp, modifier = Modifier.padding(start = 20.dp))
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .horizontalScroll(rememberScrollState())

            ) {
                Text("Ждут действий", fontSize = 20.sp)
                Text("Активные", fontSize = 20.sp)
                Text("Черновики", fontSize = 20.sp, maxLines = 1)
            }
            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 120.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(26.dp)
            ) {
                items(
                    items = favorites,
                    itemContent = {
                        AdvertismentListItem(product = it)
                    }
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
            ) {
                Text("Разместить объявление",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
            }

        }
    }
}
@Composable
@Preview
fun AdvertisementsPagePreview(){
AdvertisementsPage()
}