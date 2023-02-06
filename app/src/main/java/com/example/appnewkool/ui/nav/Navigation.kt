package com.example.appnewkool.ui.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.appnewkool.ui.home.HomeScreen
import com.example.appnewkool.ui.login.signin.SignInScreen
import com.example.appnewkool.ui.product.detail.DetailProductScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

//sealed class Screen(val route:String){
//    object HomeScreen : Screen("home_screen")
//    object DetailProductScreen : Screen("detail_product_screen")
//    object SignInScreen : Screen("sign_in_screen")
//}

enum class LoginRoutes {
    SignIn,
    Signup,
}

enum class HomeRoutes {
    Home,
    DetailProduct,
    EditProduct,
    AddProduct,
    RemoveProduct,
}

enum class NestedRoutes {
    Main,
    Login
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(navController: NavHostController = rememberAnimatedNavController()) {
    AnimatedNavHost(navController = navController, startDestination = NestedRoutes.Login.name) {
        loginGraph(navController)
        homeGraph(navController)
    }
}

const val duration = 1300

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.loginGraph(navController: NavHostController) {
    navigation(route = NestedRoutes.Login.name, startDestination = LoginRoutes.SignIn.name) {
        composable(route = LoginRoutes.SignIn.name,
            enterTransition = {
                // Let's make for a really long fade in
                slideIn(initialOffset = { IntOffset(1000, 0) }, animationSpec = tween(duration))
            },
            exitTransition = {
                slideOut(targetOffset = { IntOffset(-1000, 0) }, animationSpec = tween(duration))
            },
            popEnterTransition = {
                slideIn(initialOffset = { IntOffset(-1000, 0) }, animationSpec = tween(duration))
            },
            popExitTransition = {
                slideOut(targetOffset = { IntOffset(1000, 0) }, animationSpec = tween(duration))
            }
        ) {
            SignInScreen(navToHome = {
                navController.navigate(NestedRoutes.Main.name) {
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name) {
                        inclusive = true
                    }
                }
            })
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(route = NestedRoutes.Main.name, startDestination = HomeRoutes.Home.name) {
        composable(
            route = HomeRoutes.Home.name,
            enterTransition = {
                // Let's make for a really long fade in
                slideIn(initialOffset = { IntOffset(1000, 0) }, animationSpec = tween(duration))
            },
            exitTransition = {
                slideOut(
                    targetOffset = { IntOffset(-1000, 0) }, animationSpec = tween(duration)
                )
            },
            popEnterTransition = {
                slideIn(initialOffset = { IntOffset(-1000, 0) }, animationSpec = tween(duration))
            },
            popExitTransition = {
                slideOut(targetOffset = { IntOffset(1000, 0) }, animationSpec = tween(duration))
            }
        ) {
            HomeScreen() {
                navController.navigate(HomeRoutes.DetailProduct.name) {
                    launchSingleTop = true
                    popUpTo(HomeRoutes.Home.name){
                        inclusive = true
                    }
                }
            }
        }
        composable(route = HomeRoutes.DetailProduct.name,
            enterTransition = {
                // Let's make for a really long fade in
                slideIn(initialOffset = { IntOffset(1000, 0) }, animationSpec = tween(duration))
            },
            exitTransition = {
                slideOut(targetOffset = { IntOffset(-1000, 0) }, animationSpec = tween(duration))
            },
            popEnterTransition = {
                slideIn(initialOffset = { IntOffset(-1000, 0) }, animationSpec = tween(duration))
            },
            popExitTransition = {
                slideOut(targetOffset = { IntOffset(1000, 0) }, animationSpec = tween(duration))
            }
        ) {
            DetailProductScreen()
        }
    }
}
