package com.example.pupry.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pupry.ui.component.SearchText
import com.example.pupry.ui.component.TopAppBar


@Composable
fun HomeScreen(modifier : Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        TopAppBar {

            Icon(imageVector = Icons.Default.AccountCircle,"",
                modifier = Modifier.size(56.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp)
                    .clickable { Unit })

            SearchText(modifier = Modifier.align(Alignment.Center).fillMaxWidth(0.6f))

            Icon(imageVector = Icons.Default.Add,"",
                modifier = Modifier.size(56.dp)
                    .align(Alignment.CenterEnd)
                    .padding(10.dp)
                    .clickable{ Unit })

        }

        Box(modifier = Modifier.fillMaxSize()){
            Text("Home")
        }

    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}