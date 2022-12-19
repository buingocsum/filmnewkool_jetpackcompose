package com.example.appnewkool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.appnewkool.ui.login.signin.SignInScreen
import com.example.appnewkool.ui.theme.AppNewkoolTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNewkoolTheme {
                // A surface container using the 'background' color from the theme
               MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SignInScreen()
    }

}
