package com.example.avitowfxbarrett.pages

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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avitowfxbarrett.data.Message
import com.example.avitowfxbarrett.listItem.CategoryListItem
import com.example.avitowfxbarrett.listItem.MessageListItem
import com.example.avitowfxbarrett.viewModel.MessagePageViewModel
import java.nio.file.WatchEvent

@Composable
fun MessagePage() {
    Scaffold { padding->
            MessagePageWindow(modifier = Modifier.padding(padding))
    }
}

fun filterMessage(list: List<Message>, filterText: String):List<Message>{
        var  filterMessage:List<Message> = list
    if (!filterText.isEmpty()) {
        filterMessage =  list.filter {
            it.text.toString() == filterText.lowercase()
        }

    }
        return filterMessage

}

@Composable
@Preview
fun MessagePagePreview(){
MessagePage()
}
@Composable
fun MessagePageWindow(modifier: Modifier){
    val viewModel: MessagePageViewModel = viewModel()
    val message = listOf(Message(id = 1, 1, 1, 1, "text", "text",))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Row {
                TextField(
                    value = viewModel.textSearch,
                    onValueChange = { viewModel.textSearch = it },
                    label = { Text("Поиск по сообщениям") },
                    modifier = Modifier.clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "")
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Card(
            ) {
                Text(
                    "Непрочитанные",
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            Card() {
                Text("Важные", modifier = Modifier.padding(5.dp), fontWeight = FontWeight.Bold)
            }
            Card() {
                Text(
                    "Все объявления",
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)

        ) {
            val filterMessage = filterMessage(message,viewModel.textSearch)
            items(
                items = filterMessage,
                itemContent = {
                    MessageListItem(message = it)
                }

            )
        }
    }
}