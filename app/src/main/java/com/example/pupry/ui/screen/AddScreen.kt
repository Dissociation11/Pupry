package com.example.pupry.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pupry.compositionLocal.LocalSongViewModel
import com.example.pupry.ui.component.SongItem
import com.example.pupry.ui.component.TopAppBar
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun AddScreen(modifier : Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()){

        var songViewModel = LocalSongViewModel.current

        TopAppBar {
            Text("本地音乐",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center))
        }

        LazyColumn(modifier = Modifier.fillMaxSize()){

            items(songViewModel.list){song->
                SongItem(song = song)
            }

        }

    }
}


@Preview
@Composable
fun AddScreenPreview(){
    AddScreen()
}