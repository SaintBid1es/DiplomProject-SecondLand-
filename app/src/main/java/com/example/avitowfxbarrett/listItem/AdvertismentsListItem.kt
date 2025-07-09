package com.example.avitowfxbarrett.listItem



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
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avitowfxbarrett.data.Favorite
import com.example.avitowfxbarrett.data.FavoriteProvider
import com.example.avitowfxbarrett.data.ProductModels
import com.example.avitowfxbarrett.data.ProductProvider

@Composable
fun AdvertismentListItem(product: ProductModels) {
    // val productId = favorite.productId

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
                    Text(text = "${product.title} ")
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Create, contentDescription = "", modifier = Modifier
                            .size(20.dp))
                    }

                }
                Text(text = "${product.cost} $", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Row {
                    Icon(Icons.Default.Face, contentDescription = "")
                    Text("1563")
                    Icon(Icons.Default.Person, contentDescription = "")
                    Text("33")
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "")
                    Text("106")
                }

            }


        }
    }
}


@Composable
@Preview
fun AdvertismentListItemPreview() {
    MaterialTheme {
        // FavoriteListItem(FavoriteProvider.favorite)
        AdvertismentListItem(ProductProvider.product)
    }
}