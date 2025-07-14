package com.example.avitowfxbarrett.presentaion.listItem




import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avitowfxbarrett.R
import com.example.avitowfxbarrett.data.model.Message
import com.example.avitowfxbarrett.data.model.ProductProvider

@Composable
fun MessageListItem(message: Message ) {
    // val productId = favorite.productId
    val product = ProductProvider.product
    Card(
        modifier = Modifier
            .width(400.dp)
            .height(120.dp)
            ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
        ,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Box(){
                Image(
                    painter = painterResource(id = R.drawable.guitar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Image(
                    painter = painterResource(id = R.drawable.ava),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(30.dp))
                )

            }


            Spacer(modifier = Modifier.width(30.dp))
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Ekaterina")
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(message.createdAt.toString(), maxLines = 1)
                }
                    Text(text = product.title)
                    Text(text = message.text, maxLines = 1)

            }


        }
    }
}


@Composable
@Preview
fun MessageListItemPreview() {
    MaterialTheme {
        // FavoriteListItem(FavoriteProvider.favorite)
        MessageListItem(message = Message(id=1,1,1,1,"text","text",))
    }
}