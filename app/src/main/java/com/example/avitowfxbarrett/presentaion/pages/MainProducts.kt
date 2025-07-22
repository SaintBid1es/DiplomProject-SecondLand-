package com.example.avitowfxbarrett.presentaion.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.avitowfxbarrett.data.model.CategoryProvider
import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.presentaion.listItem.CategoryListItem
import com.example.avitowfxbarrett.presentaion.listItem.ProductListItem
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.viewModel.ProductsMainViewModel

fun filterItems(items: List<ProductModels>, query: String): List<ProductModels> {
    val lowerCaseQuery = query.lowercase()
    return items.filter {
        it.title.lowercase().contains(lowerCaseQuery)
    }
}

@Composable
fun MainProducts(navController: NavHostController) {
    val viewModel : ProductsMainViewModel = viewModel()
    val categories = remember { CategoryProvider.categoryList }
    val products = remember { ProductProvider.productList }
    val filteredItems = filterItems(products, viewModel.textSearch)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = viewModel.textSearch,
                onValueChange = { viewModel.textSearch = it },
                label = { Text("Поиск ") },
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp)),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),


                )
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
        }
        LazyRow(
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(
                items = categories,
                itemContent = {
                    CategoryListItem(category = it)
                }
            )
        }
        Text(
            text = "Рекомендации",
            modifier = Modifier.padding(start = 10.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),


            ) {
            items(
                items = filteredItems,
                itemContent = {
                    ProductListItem(product = it,navController)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AvitoWfxbarrettTheme {
        val navController = rememberNavController()
        MainProducts(navController = navController)
    }
}