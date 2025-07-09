package com.example.avitowfxbarrett.listItem

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avitowfxbarrett.data.ProductModels
import com.example.avitowfxbarrett.data.ProductProvider
import com.example.avitowfxbarrett.viewModel.ProductsMainViewModel

@Composable
fun ProductListItem(product: ProductModels,navigatetoProfile:(ProductModels)->Unit) {
    val viewModel: ProductsMainViewModel = viewModel()
    val isFavorite by remember(product.id) {
        derivedStateOf { viewModel.isFavorite(product) }
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .width(160.dp)
            .height(200.dp)
            .clickable(onClick = {
               navigatetoProfile(product)

            }),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = product.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp)))

                        Spacer(modifier = Modifier.height(8.dp))


                        Row(
                        modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier.weight(1f).padding(end = 4.dp))

                    IconButton(onClick = {
                          viewModel.changeFavorite(product)
                    }) {

                        if (isFavorite==true) {
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(20.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }else{
                            Icon(
                                Icons.Filled.FavoriteBorder,
                                contentDescription = "Not Favorite",
                                modifier = Modifier.size(20.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

            }

            Spacer(modifier = Modifier.height(4.dp))

            // Price
            Text(
                text = "${product.cost} $",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary)

            Spacer(modifier = Modifier.height(4.dp))

            // Location row
            if (product.location != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        modifier = Modifier.size(14.dp))

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = product.location,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
@Preview
fun ProductListItemPreview() {
    MaterialTheme {
        ProductListItem(ProductProvider.product,{})
    }
}