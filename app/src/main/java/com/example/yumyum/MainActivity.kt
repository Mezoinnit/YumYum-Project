package com.example.yumyum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.yumyum.presentation.MainScreen
import com.example.yumyum.ui.theme.YumYumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YumYumTheme {
                MainScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Yum() {
    YumYumTheme {

    }
}