package com.example.avitowfxbarrett

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avitowfxbarrett.ui.theme.AvitoWfxbarrettTheme

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AvitoWfxbarrettTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ForgotPass(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ForgotPass( modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
           ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)

        ) {
            IconButton(
                onClick = {},
                modifier = Modifier.padding()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "return on Main window")
            }
            Text(text = "Forgot Password", fontSize = 20.sp, textAlign = TextAlign.Center)
        }
        Row {
            TextField(
                value = email,
                onValueChange = {email=it},
                label = {Text("Input your email")}
            )
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Filled.Check, contentDescription = "Info on check email verification")
            }
        }
        Button(
            onClick = {},
            modifier = Modifier.width(200.dp)
        ) {
            Text("Confirm")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AvitoWfxbarrettTheme {
        ForgotPass()
    }
}