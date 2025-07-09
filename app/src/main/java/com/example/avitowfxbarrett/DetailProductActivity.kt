package com.example.avitowfxbarrett

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.avitowfxbarrett.data.ProductModels
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme

class DetailProductActivity : ComponentActivity() {

    private val product: ProductModels by lazy {
        intent?.getSerializableExtra(PRODUCT_ID) as ProductModels
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvitoWfxbarrettTheme {
                Text(product.title)
            }
        }
    }
    companion object{
        private const val PRODUCT_ID = "product_id"
        fun newIntent(context: Context,productModels: ProductModels) = Intent(context,
            DetailProductActivity::class.java).apply {
                putExtra(PRODUCT_ID,productModels)
        }
    }
}




//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview4() {
//    AvitoWfxbarrettTheme {
//
//    }
//}