package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.presentaion.listItem.FavoriteListItem
import com.example.avitowfxbarrett.presentaion.state.FavoriteIntent
import com.example.avitowfxbarrett.presentaion.state.FavoriteState
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.viewModel.FavoriteViewModel

@Composable
fun FavoritePage(
    viewModel: FavoriteViewModel = viewModel()
) {
    AvitoWfxbarrettTheme {
        // val favorites = remember { FavoriteProvider.favoriteList }

        val state = viewModel.state.collectAsState().value

        when (state) {
            is FavoriteState.Success -> {

                Success(state.favorites,viewModel)
            }
            is FavoriteState.Error -> {
                ErrorView(message = state.message)
            }

            is FavoriteState.Loading -> {
                LoadingView()
            }


        }


    }
}

@Composable
fun Success(
    favorites: List<ProductModels>,
    viewModel: FavoriteViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp),
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                ,
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(26.dp)


        ) {
            items(
                items = favorites,
                itemContent = {
                    FavoriteListItem(product = it, changeFavorite = {viewModel.processIntent(
                        FavoriteIntent.ChangeFavorite,it) }, viewModel = viewModel
                    )
                }
            )
        }


    }
}


@Composable
@Preview
fun FavoritePagePreview() {
    FavoritePage()
}

@Composable
 fun LoadingView() {
    Box(
        modifier = Modifier.Companion.fillMaxSize(),
        contentAlignment = Alignment.Companion.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
 fun ErrorView(message: String) {
    Box(
        modifier = Modifier.Companion.fillMaxSize(),
        contentAlignment = Alignment.Companion.Center
    ) {
        Text(
            text = "Error: $message",
            color = Color.Companion.Red,
            fontSize = 18.sp
        )
    }
}