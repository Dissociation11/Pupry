package com.example.pupry.ui.screen

import android.webkit.PermissionRequest
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pupry.model.entity.BottomNavigationItem
import com.example.pupry.model.entity.ContentType
import com.example.pupry.ui.component.MainBackground
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainFrame(onNavigateToSongScreen : ()->Unit = {},onNavigateToVideoScreen:() -> Unit = {},onNavigateToLogin:() -> Unit = {},onNavigateToVersion:()->Unit = {}){

    var selectedItem by remember { mutableStateOf(BottomNavigationItem.Home) }
    var selectedLabel by remember { mutableStateOf(selectedItem.title) }


    Box(modifier = Modifier.fillMaxSize()){

        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = MainBackground)
            .padding(bottom = 80.dp)){

            when(selectedItem){
                BottomNavigationItem.Home -> HomeScreen(modifier = Modifier, onNavigateToSongScreen = onNavigateToSongScreen, onNavigateToVideoScreen = onNavigateToVideoScreen)
                BottomNavigationItem.Add -> AddScreen(modifier = Modifier)
                BottomNavigationItem.Account -> AccountScreen(modifier = Modifier, onNavigateToLogin = onNavigateToLogin, onNavigateToVersion = onNavigateToVersion)
            }

        }

        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter)){
            BottomNavigationItem.values().forEach {tab->
                NavigationBarItem(
                    selected = tab == selectedItem,
                    onClick = {
                        selectedItem = tab
                        selectedLabel = tab.title

                        if(tab == BottomNavigationItem.Add){

                        }

                    },
                    label = { Text(tab.title) },
                    icon = { Icon(tab.icon,tab.title) })
            }
        }

    }

}

@Preview
@Composable
fun MainFramePreview(){
    MainFrame()
}