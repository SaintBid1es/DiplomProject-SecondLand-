package com.example.avitowfxbarrett.pages

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avitowfxbarrett.ContentScreen
import com.example.avitowfxbarrett.R
import com.example.avitowfxbarrett.ui.theme.BlueForCard
import java.nio.file.WatchEvent

@Composable
fun ProfilePage() {
    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(20.dp)
                .padding(bottom = 125.dp), // Увеличиваем отступ для навигации
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Наверх")
                }
                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Уведомления")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Settings, contentDescription = "Настройки")
                    }
                }
            }


            Image(
                painter = painterResource(R.drawable.ava),
                contentDescription = "Аватар",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .border(
                        border = BorderStroke(3.dp, BlueForCard),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .clip(RoundedCornerShape(32.dp))
            )

            Text("Марк", fontSize = 20.sp)
            Text("На Авито с 2023 года", fontSize = 16.sp)
            Text("Номер профиля 321 654", fontSize = 16.sp)


            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("5,0", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                repeat(5) {
                    Icon(
                        painter = painterResource(R.drawable.star_ic),
                        contentDescription = "Звезда рейтинга",
                        tint = Color.Yellow
                    )
                }
            }

            Text("1 Отзыв", color = BlueForCard, fontWeight = FontWeight.Bold)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Финансы")
                IconButton(onClick = {}) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Перейти")
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text("0 P", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text("Avito кошелёк")
                }
            }


            SectionTitle("Заказы")
            EmptySection(icon = painterResource(R.drawable.description_ic), text = "Пока пусто")

            SectionTitle("Адреса")

            SectionTitle("Объявления")
            EmptySection(icon = painterResource(R.drawable.advertisment_ic), text = "6 активных")
            SectionItem(icon = Icons.Filled.Warning, text = "1 ждет активации")

            Text(
                text = "Перейти к объявлениям",
                color = BlueForCard,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 16.dp))
        }
    }
}

// Вспомогательные компоненты для улучшения читаемости
@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier.padding(top = 8.dp))
}

@Composable
private fun EmptySection(icon: Painter, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null)
        Text(text, modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
private fun SectionItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null)
        Text(text, modifier = Modifier.padding(start = 10.dp))
    }
}




@Composable
@Preview
fun ProfilePagePreview() {
    ProfilePage()
}