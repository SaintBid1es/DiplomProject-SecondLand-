package com.example.avitowfxbarrett.presentaion.listItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avitowfxbarrett.data.model.Category
import com.example.avitowfxbarrett.data.model.CategoryProvider

@Composable
fun CategoryListItem(category: Category){
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            CategoryImage(category)
            Text(text = category.title)

        }
    }

}
@Composable
private fun CategoryImage(category: Category){
    Image(
        painter = painterResource(id = category.imageId),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.padding(8.dp)
            .size(64.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
    )
}

@Composable
@Preview
fun CategoryListItemPreview(){

    CategoryListItem(CategoryProvider.category)
}