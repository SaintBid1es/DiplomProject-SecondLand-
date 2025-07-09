package com.example.avitowfxbarrett

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import com.example.avitowfxbarrett.data.CategoryProvider
import com.example.avitowfxbarrett.data.ProductModels
import com.example.avitowfxbarrett.data.ProductProvider
import com.example.avitowfxbarrett.listItem.CategoryListItem
import com.example.avitowfxbarrett.listItem.ProductListItem
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.viewModel.ProductsMainViewModel

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvitoWfxbarrettTheme {
                MainScreen(modifier = Modifier.padding(),{
                    startActivity(DetailProductActivity.newIntent(this,it))
                })

            }
        }
    }
}
fun filterItems(items: List<ProductModels>, query: String): List<ProductModels> {
    val lowerCaseQuery = query.lowercase()
    return items.filter {
        it.title.lowercase().contains(lowerCaseQuery)
    }
}

@Composable
fun MainProducts( modifier: Modifier = Modifier,navigateToProfile: (ProductModels)->Unit) {
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
        ){
            TextField(
                value = viewModel.textSearch,
                onValueChange = {viewModel.textSearch=it},
                label = {Text("Поиск ")},
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
                contentPadding = PaddingValues( vertical = 8.dp)
        ) {
            items(
                items = categories,
                itemContent = {
                    CategoryListItem(category = it)
                }
            )
        }
        Text(text = "Рекомендации",
            modifier = Modifier.padding(start = 10.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(bottom = 120.dp)
        ) {
            items(
                items = filteredItems,
                itemContent = {
                    ProductListItem(product = it,navigateToProfile)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AvitoWfxbarrettTheme {
        MainProducts(modifier = Modifier.padding(),{})
    }

}

