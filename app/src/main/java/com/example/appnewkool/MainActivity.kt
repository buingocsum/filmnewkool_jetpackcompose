package com.example.appnewkool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.appnewkool.ui.nav.Navigation
import com.example.appnewkool.ui.theme.AppNewkoolTheme
import com.example.appnewkool.ui.theme.BlueWhite
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNewkoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = BlueWhite) {
                    Navigation()
                }
            }
        }
    }
}
