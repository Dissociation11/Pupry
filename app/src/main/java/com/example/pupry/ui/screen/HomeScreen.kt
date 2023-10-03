package com.example.pupry.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeScreen(modifier : Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text("Home",Modifier.align(Alignment.Center))
    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(Modifier)
}