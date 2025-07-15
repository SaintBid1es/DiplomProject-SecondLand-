package com.example.avitowfxbarrett.presentaion.listItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.viewModel.FavoriteViewModel

@Composable
fun FavoriteListItem(product: ProductModels,
                      viewModel: FavoriteViewModel,
                     changeFavorite:(ProductModels)->Unit) {
    // val productId = favorite.productId

    val isFavorite by remember(product.id) {
        derivedStateOf {
            viewModel.isFavorite(product)
        }
    }
    Card(
        modifier = Modifier
            .width(400.dp)
            .height(150.dp)
            ,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)


        ) {
            Image(
                painter = painterResource(id = product.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(30.dp))
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(text = "${product.cost} $")

                        IconButton(onClick =
                            { changeFavorite(product) }
                        ) {
                            if (isFavorite)
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(20.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                            else{
                                Icon(
                                    Icons.Default.FavoriteBorder,
                                    contentDescription = "Not favorite",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }

                Text(text = "${product.title}")
                if (product.location != null){
                    Text(text = product.location)
                }
                Text(text = "Время: " + product.time.toString())

            }


        }
    }
}

//
//@Composable
//@Preview
//fun FavoriteListItemPreview() {
//    MaterialTheme {
//        // FavoriteListItem(FavoriteProvider.favorite)
//        FavoriteListItem(ProductProvider.product)
//    }
//}