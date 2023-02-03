package com.example.appnewkool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnewkool.ui.home.HomeScreen
import com.example.appnewkool.ui.login.signin.SignInScreen
import com.example.appnewkool.ui.nav.Screen
import com.example.appnewkool.ui.theme.AppNewkoolTheme
//import com.google.accompanist.navigation.animation.AnimatedNavHost
//import com.google.accompanist.navigation.animation.composable
//import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
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

val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioMediumBouncy)
val tweenSpec = tween<IntOffset>(durationMillis = 2000, easing = CubicBezierEasing(0.08f,0.93f,0.68f,1.27f))

@ExperimentalAnimationApi
@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignInScreen.route) {
        composable(route = Screen.HomeScreen.route,
        ) {
            HomeScreen()
        }
        composable(route = Screen.SignInScreen.route){
            SignInScreen(navController = navController)
        }
    }

//    val navController = rememberAnimatedNavController()
//    AnimatedNavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
//        composable(
//            route = Screen.HomeScreen.route,
//            enterTransition = { initial, _ ->
//                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
//            },
//            exitTransition = { _, target ->
//                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
//            },
//            popEnterTransition = { initial, _ ->
//                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
//            },
//            popExitTransition = { _, target ->
//                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
//            }
//        ) { HomeScreen() }
//        composable(route = Screen.SignInScreen.route,
//            enterTransition = { initial, _ ->
//                slideInVertically(initialOffsetY = { 1000 }, animationSpec = tweenSpec)
//            },
//            exitTransition = { _, target ->
//                slideOutVertically(targetOffsetY = { -1000 }, animationSpec = tweenSpec)
//            },
//            popEnterTransition = { initial, _ ->
//                slideInVertically(initialOffsetY = { -1000 }, animationSpec = tweenSpec)
//            },
//            popExitTransition = { _, target ->
//                slideOutVertically(targetOffsetY = { 1000 }, animationSpec = tweenSpec)
//            }
//        ) {
//            SignInScreen(navController = navController)
//        }
//    }
}
