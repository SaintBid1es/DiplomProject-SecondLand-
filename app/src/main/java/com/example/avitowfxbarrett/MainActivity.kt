package com.example.avitowfxbarrett

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.avitowfxbarrett.data.API.RetrofitClient
import com.example.avitowfxbarrett.data.model.BottomNavItem
import com.example.avitowfxbarrett.data.model.CategoryProvider
import com.example.avitowfxbarrett.data.model.ProductModels
import com.example.avitowfxbarrett.data.model.ProductProvider
import com.example.avitowfxbarrett.data.model.User
import com.example.avitowfxbarrett.presentaion.listItem.CategoryListItem
import com.example.avitowfxbarrett.presentaion.listItem.ProductListItem
import com.example.avitowfxbarrett.presentaion.pages.AdTypePage
import com.example.avitowfxbarrett.presentaion.pages.AddProductPage
import com.example.avitowfxbarrett.presentaion.pages.AdvertisementsPage
import com.example.avitowfxbarrett.presentaion.pages.DetailProductPage
import com.example.avitowfxbarrett.presentaion.pages.DontHaveAccountPage
import com.example.avitowfxbarrett.presentaion.pages.ErrorView
import com.example.avitowfxbarrett.presentaion.pages.FavoritePage
import com.example.avitowfxbarrett.presentaion.pages.ForgotPass
import com.example.avitowfxbarrett.presentaion.pages.IndicateNameProductPage
import com.example.avitowfxbarrett.presentaion.pages.InputDescriptionProductPage
import com.example.avitowfxbarrett.presentaion.pages.LoadingView
import com.example.avitowfxbarrett.presentaion.pages.MainProducts
import com.example.avitowfxbarrett.presentaion.pages.MessagePage
import com.example.avitowfxbarrett.presentaion.pages.ProfilePage
import com.example.avitowfxbarrett.presentaion.pages.SelectAddresForProductPage
import com.example.avitowfxbarrett.presentaion.pages.SelectCategoryPage
import com.example.avitowfxbarrett.presentaion.pages.SelectStateProductPage
import com.example.avitowfxbarrett.presentaion.pages.TermsOfPage
import com.example.avitowfxbarrett.presentaion.pages.TermsOfPagePreview
import com.example.avitowfxbarrett.presentaion.state.LoginIntent
import com.example.avitowfxbarrett.presentaion.state.LoginState
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme
import com.example.avitowfxbarrett.ui.theme.Purple40
import com.example.avitowfxbarrett.viewModel.MainViewModel
import com.example.avitowfxbarrett.viewModel.ProductsMainViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AvitoWfxbarrettTheme {
                val navController = rememberNavController()
                var showBottomBar by remember { mutableStateOf(false) }
                val MainViewModel: MainViewModel = viewModel()
                var pageIsAdvertisment by remember { mutableStateOf(false) }
                Scaffold(
                    bottomBar = {
                            if (pageIsAdvertisment) {
                                FloatingActionButton(
                                    onClick = {
                                     navController.navigate(Routes.AddProduct.route)
                                    },
                                    modifier = Modifier
                                        .offset(y = (-72).dp)
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        , backgroundColor =  (Color.Black)
                                ) {
                                    Text(
                                        "Разместить объявление",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
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
                            pageIsAdvertisment = false
                        }
                        composable(Routes.Advertisment.route) {
                            AdvertisementsPage()
                            showBottomBar = true
                            pageIsAdvertisment = true
                        }
                        composable(Routes.Message.route) {
                            MessagePage()
                            showBottomBar = true
                            pageIsAdvertisment = false
                        }
                        composable(Routes.Login.route) {
                            Login(navController,this@MainActivity, MainViewModel)
                            showBottomBar = false
                            pageIsAdvertisment = false
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

                            ProfilePage(navController, MainViewModel)
                            showBottomBar = true
                            pageIsAdvertisment = false
                        }
                        composable(Routes.Favorites.route) {
                            FavoritePage()
                            showBottomBar = true
                            pageIsAdvertisment = false
                        }
                        composable(Routes.ForgotPassword.route) {
                            ForgotPass(navigation = navController)
                            showBottomBar = false
                            pageIsAdvertisment = false
                        }
                        composable(Routes.DontHaveAccount.route) {
                            DontHaveAccountPage(navController)
                            showBottomBar = false
                            pageIsAdvertisment = false
                        }
                        navigation(
                            startDestination = Routes.AddProduct.route,
                            route = "create_product_flow"
                        ) {
                            composable(Routes.AddProduct.route) { AddProductPage(navController)
                                showBottomBar = false
                            pageIsAdvertisment = false
                            }

                            composable(Routes.IndicateNameProduct.route) { IndicateNameProductPage(navController)
                                showBottomBar = false
                                pageIsAdvertisment = false
                            }
                            composable(Routes.TermsOfPage.route) {
                                TermsOfPage(navController)
                                showBottomBar = false
                                pageIsAdvertisment = false
                            }
                            composable(Routes.AdType.route) {
                            AdTypePage(navController)
                            showBottomBar = false
                            pageIsAdvertisment = false
                        }

                            composable(Routes.InputDescriptionProduct.route) {
                                InputDescriptionProductPage(navController)
                                showBottomBar = false
                                pageIsAdvertisment = false
                            }
                            composable(Routes.SelectAddresForProduct.route) {
                                SelectAddresForProductPage(navController)
                                showBottomBar = false
                                pageIsAdvertisment = false
                            }
                            composable(Routes.SelectCategory.route) {
                                SelectCategoryPage(navController)
                                showBottomBar = false
                                pageIsAdvertisment = false
                            }
                            composable(Routes.SelectStateProduct.route) {
                                SelectStateProductPage(navController)
                                showBottomBar = false
                                pageIsAdvertisment = false
                            }

                        }


                    }
                }

            }
        }
    }
}



@SuppressLint("ResourceAsColor")
@Composable
fun Login(navController: NavHostController,context: Context,viewModel: MainViewModel) {
    val state = viewModel.state.collectAsState().value

    when(state){
        is LoginState.Error -> ErrorView(state.message)
        LoginState.Loading -> LoadingView()
        is LoginState.Success -> LoginSuccess(navController,context,viewModel)
        LoginState.Idle -> {
            LoginSuccess(navController,context,viewModel)
        }
    }

}

@Composable
fun LoginSuccess(navController: NavHostController,context: Context,viewModel: MainViewModel){

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
            onValueChange = { viewModel.processIntent(LoginIntent.InputEmail(it),navController,context)},
            label = { Text("Write to your email") }
        )

        TextField(
            value = viewModel.passwordText,
            onValueChange = { viewModel.processIntent(LoginIntent.InputPassword(it),navController,context) },
            label = { Text("Write to your password") }
        )

        Button(
            onClick = {
               viewModel.processIntent(LoginIntent.ClickButtonLogin,navController,context)
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
                   viewModel.processIntent(LoginIntent.ClickButtonRegister,navController,context)
                })

            )
            Text(
                text = "Forgot password?",
                color = Purple40,
                modifier = Modifier.clickable(onClick = {
                    viewModel.processIntent(LoginIntent.ClickButtonForgotPassword,navController,context)
                })

            )

        }


    }
}



