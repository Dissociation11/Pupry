package com.example.pupry.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddScreen(modifier : Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text("Add",Modifier.align(Alignment.Center))
    }
}


@Preview
@Composable
fun AddScreenPreview(){
    AddScreen()
}