package com.example.avitowfxbarrett

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.avitowfxbarrett.data.ProductModels
import com.example.avitowfxbarrett.listItem.NavItem
import com.example.avitowfxbarrett.pages.AdvertisementsPage
import com.example.avitowfxbarrett.pages.FavoritePage
import com.example.avitowfxbarrett.pages.HomePage
import com.example.avitowfxbarrett.pages.MessagePage
import com.example.avitowfxbarrett.pages.ProfilePage

@Composable
fun MainScreen(modifier: Modifier,navigateToProfile: (ProductModels)->Unit){
    val navItemList = listOf(
        NavItem("Поиск", Icons.Default.Home, 0),
        NavItem("Избранные", Icons.Default.Favorite, 0),
        NavItem("Объявления", Icons.Filled.AddCircle, 0),
        NavItem("Сообщения", Icons.Default.MailOutline, 15),
        NavItem("Профиль", Icons.Filled.AccountCircle, 0)
    )
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed {
                    index,navItem->
                    NavigationBarItem(selected = selectedIndex==index ,onClick={
                        selectedIndex = index
                    },icon={
                        BadgedBox(
                            badge = {
                                if (navItem.badgeCount>0)
                                Badge(){
                                    Text(text = navItem.badgeCount.toString())
                                }
                            }
                        ) {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        }

                    }, label = {
                        Text(text = navItem.label)
                    })
                }
            }
        }) { innerpadding->
        ContentScreen(modifier = Modifier.padding(innerpadding),selectedIndex,navigateToProfile)

    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex: Int,navigateToProfile: (ProductModels)->Unit){
    when(selectedIndex){
        0-> HomePage(navigateToProfile)
        1-> FavoritePage()
        2-> AdvertisementsPage()
        3-> MessagePage()
        4-> ProfilePage()
    }
}