package com.example.appnewkool.ui.nav

sealed class Screen(val route:String){
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
    object SignInScreen : Screen("sign_in_screen")
}
