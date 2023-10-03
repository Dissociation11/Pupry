package com.example.pupry.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.pupry.model.entity.BottomNavigationItem
import com.example.pupry.ui.component.FirstColor
import com.example.pupry.ui.component.LastColor
import com.example.pupry.ui.component.MainBackground

@Composable
fun MainFrame(){

    var selectedItem by remember { mutableStateOf(BottomNavigationItem.Home) }
    var selectedLabel by remember { mutableStateOf(selectedItem.title) }


    Box(modifier = Modifier.fillMaxSize()){

        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = MainBackground)){

            when(selectedItem){
                BottomNavigationItem.Home -> HomeScreen(modifier = Modifier)
                BottomNavigationItem.Add -> AddScreen(modifier = Modifier)
                BottomNavigationItem.Account -> AccountScreen(modifier = Modifier)
            }

        }

        NavigationBar(modifier = Modifier.align(Alignment.BottomCenter)){
            BottomNavigationItem.values().forEach {tab->
                NavigationBarItem(
                    selected = tab == selectedItem,
                    onClick = {
                        selectedItem = tab
                        selectedLabel = tab.title
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