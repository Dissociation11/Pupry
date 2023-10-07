package com.example.pupry.ui.navigation

sealed class Screen(val  route : String){

    object HomeScreen : Screen("HomeScreen")

    object SongScreen : Screen("SongScreen")

    object VideoScreen : Screen("VideoScreen")

    object LoginScreen : Screen("LoginScreen")

    object RegestScreen : Screen("RegestScreen")

}