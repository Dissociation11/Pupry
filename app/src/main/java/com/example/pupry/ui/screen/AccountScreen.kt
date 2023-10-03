package com.example.pupry.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pupry.ui.component.TopAppBar

@Composable
fun AccountScreen(modifier : Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()){
        TopAppBar {
            Text("我的")
        }
        Box(modifier = Modifier.fillMaxSize()){
            Text("我的",modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview
@Composable
fun AccountScreenPreview(){
    AccountScreen()
}