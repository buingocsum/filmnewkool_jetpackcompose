package com.example.test
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.appnewkool.ui.theme.AppNewkoolTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNewkoolTheme() {
                AnimatedApp()
                // Comment out AnimatedApp above and uncomment NonAmimatedApp below for the
                // status quo of how navigation is handled
                // NonAnimatedApp()
            }
        }
    }
}