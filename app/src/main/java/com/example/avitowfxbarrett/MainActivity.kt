package com.example.avitowfxbarrett

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.avitowfxbarrett.data.model.BottomNavItem
import com.example.avitowfxbarrett.data.model.CategoryProvider
import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.presentaion.listItem.CategoryListItem
import com.example.avitowfxbarrett.presentaion.listItem.ProductListItem
import com.example.avitowfxbarrett.presentaion.pages.AdvertisementsPage
import com.example.avitowfxbarrett.presentaion.pages.DetailProductPage
import com.example.avitowfxbarrett.presentaion.pages.DontHaveAccountPage
import com.example.avitowfxbarrett.presentaion.pages.FavoritePage
import com.example.avitowfxbarrett.presentaion.pages.ForgotPass
import com.example.avitowfxbarrett.presentaion.pages.MessagePage
import com.example.avitowfxbarrett.presentaion.pages.ProfilePage
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.ui.theme.Purple40
import com.example.avitowfxbarrett.viewModel.MainViewModel
import com.example.avitowfxbarrett.viewModel.ProductsMainViewModel
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AvitoWfxbarrettTheme {
                val navController = rememberNavController()
                var showBottomBar by remember { mutableStateOf(false) }
                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavigation(
                                backgroundColor = Color.White
                            ) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination

                                val bottomNavItems = listOf(
                                    BottomNavItem(
                                        name = "Home",
                                        route = Routes.Home.route,
                                        icon = Icons.Filled.Home
                                    ),
                                    BottomNavItem(
                                        name = "Favorites",
                                        route = Routes.Favorites.route,
                                        icon = Icons.Filled.Favorite
                                    ),
                                    BottomNavItem(
                                        name = "Advertisment",
                                        route = Routes.Advertisment.route,
                                        icon = Icons.Filled.AddCircle
                                    ),
                                    BottomNavItem(
                                        name = "Message",
                                        route = Routes.Message.route,
                                        icon = Icons.Filled.MailOutline
                                    ),
                                    BottomNavItem(
                                        name = "Profile",
                                        route = Routes.Profile.route,
                                        icon = Icons.Filled.AccountCircle
                                    ),
                                )

                                bottomNavItems.forEach { item ->
                                    BottomNavigationItem(
                                        icon = { Icon(item.icon, contentDescription = item.name) },
                                        label = { Text(item.name) },
                                        selected = currentDestination?.route == item.route,
                                        onClick = {
                                            navController.navigate(item.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController, startDestination = Routes.Login.route, Modifier.padding(innerPadding)) {
                        composable(Routes.Home.route) {
                            MainProducts(navController)
                            showBottomBar = true
                        }
                        composable(Routes.Advertisment.route) {
                            AdvertisementsPage()
                            showBottomBar = true
                        }
                        composable(Routes.Message.route) {
                            MessagePage()
                            showBottomBar = true
                        }
                        composable(Routes.Login.route) {
                            Login(navController)
                            showBottomBar = false
                        }
                        composable(
                            route = Routes.ProductDetailJSON.route,
                            arguments = listOf(navArgument("productJson") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val productJson = backStackEntry.arguments?.getString("productJson") ?: ""
                            val product = Gson().fromJson(productJson, ProductModels::class.java)
                            DetailProductPage(product)
                        }
                        composable(Routes.Profile.route) {
                            ProfilePage(navController)
                            showBottomBar = true
                        }
                        composable(Routes.Favorites.route) {
                            FavoritePage()
                            showBottomBar = true
                        }
                        composable(Routes.ForgotPassword.route) {
                            ForgotPass(navigation = navController)
                            showBottomBar = false
                        }
                        composable(Routes.DontHaveAccount.route) {
                            DontHaveAccountPage(navController)
                            showBottomBar = false
                        }

                    }
                }
            }
        }
    }
}



@SuppressLint("ResourceAsColor")
@Composable
fun Login(navController: NavHostController) {
    val viewModel: MainViewModel = viewModel()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(36.dp)

    ) {
        Text("Welcome to Back",
            color = Color.Black,
            fontSize = 20.sp
            )

        TextField(
            value = viewModel.emailText,
            onValueChange = { viewModel.emailText = it },
            label = { Text("Write to your email") }
        )

        TextField(
            value = viewModel.passwordText,
            onValueChange = { viewModel.passwordText = it },
            label = { Text("Write to your password") }
        )

        Button(
            onClick = {
                navController.navigate(Routes.Home.route){
                    popUpTo(Routes.Login.route)
                }
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Confirm")
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            Text(
                text = "Don't have account?",
                color = Purple40,
                modifier = Modifier.clickable(onClick = {
                    navController.navigate(Routes.DontHaveAccount.route)
                })

            )
            Text(
                text = "Forgot password?",
                color = Purple40,
                modifier = Modifier.clickable(onClick = {
                    navController.navigate(Routes.ForgotPassword.route){
                        popUpTo(Routes.Login.route)
                    }
                })

            )

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
            modifier = Modifier
                .padding(bottom = 120.dp)
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