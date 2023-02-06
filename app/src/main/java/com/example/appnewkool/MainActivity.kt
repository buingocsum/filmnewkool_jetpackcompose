package com.example.appnewkool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appnewkool.ui.nav.Navigation
import com.example.appnewkool.ui.theme.AppNewkoolTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNewkoolTheme {
                // A surface container using the 'background' color from the theme
                Navigation()
            }
        }
    }
}
