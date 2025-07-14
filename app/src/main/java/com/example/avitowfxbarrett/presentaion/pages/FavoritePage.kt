package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.avitowfxbarrett.presentaion.listItem.FavoriteListItem
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme

@Composable
fun FavoritePage(){
    AvitoWfxbarrettTheme {
       // val favorites = remember { FavoriteProvider.favoriteList }
        val favorites = remember { ProductProvider.productList }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(30.dp)

                ,


            verticalArrangement = Arrangement.spacedBy(36.dp)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Избранное", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Row {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "")
                    }
                }
            }
            Row(

            ) {
                Text(text = "Объявления", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "Поиски", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "Профили", fontWeight = FontWeight.Bold)
            }
            LazyColumn (modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 120.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(26.dp)


            ){
                items(
                    items = favorites,
                    itemContent = {
                        FavoriteListItem(product = it)
                    }
                )
            }





        }
    }
}

@Composable
@Preview
fun FavoritePagePreview(){
        FavoritePage()
}