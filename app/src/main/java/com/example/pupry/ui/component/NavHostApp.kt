package com.example.pupry.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pupry.compositionLocal.LocalSongViewModel
import com.example.pupry.compositionLocal.LocalUserViewModel
import com.example.pupry.compositionLocal.LocalVideoViewModel
import com.example.pupry.ui.navigation.Screen
import com.example.pupry.ui.screen.LoginScreen
import com.example.pupry.ui.screen.MainFrame
import com.example.pupry.ui.screen.RegestScreen
import com.example.pupry.ui.screen.SongScreen
import com.example.pupry.ui.screen.VideoScreen
import com.example.pupry.viewmodel.SongViewModel
import com.example.pupry.viewmodel.UserViewModel
import com.example.pupry.viewmodel.VideoViewModel

@Composable
fun NavHostApp(){

    val navController = rememberNavController()

    CompositionLocalProvider(LocalUserViewModel provides UserViewModel(), LocalSongViewModel provides SongViewModel(),
        LocalVideoViewModel provides VideoViewModel()) {

        val userViewModel = LocalUserViewModel.current
        val songViewModel = LocalSongViewModel.current

        NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

            composable(Screen.HomeScreen.route) {
                MainFrame(onNavigateToSongScreen = {
                    navController.navigate(Screen.SongScreen.route)
                }, onNavigateToVideoScreen = {
                    navController.navigate(Screen.VideoScreen.route)
                }, onNavigateToLogin = {
                    if(userViewModel.logined){

                    }else{
                        navController.navigate(Screen.LoginScreen.route)
                    }
                })
            }

            composable(Screen.SongScreen.route) {
                SongScreen(onBack = {
                    navController.popBackStack()
                    songViewModel .onStop()
                })
            }

            composable(Screen.VideoScreen.route) {
                VideoScreen(onBack = {
                    navController.popBackStack()
                })
            }

            composable(Screen.LoginScreen.route) {
                LoginScreen(onClose = {
                    navController.popBackStack()
                }, onNavigateToRegest = {
                    navController.popBackStack()
                    navController.navigate(Screen.RegestScreen.route)
                })
            }

            composable(Screen.RegestScreen.route){
                RegestScreen(onClose = {
                    navController.popBackStack()
                }, onNavigateToLogin = {
                    navController.popBackStack()
                    navController.navigate(Screen.LoginScreen.route)
                })
            }

        }
    }

}