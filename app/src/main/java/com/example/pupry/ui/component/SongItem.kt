package com.example.pupry.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupry.R
import com.example.pupry.model.entity.SongEntity

@Composable
fun SongItem(song : SongEntity , modifier:Modifier = Modifier){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 4.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(SongBackground)){
        Row(modifier = modifier){

            Spacer(modifier = Modifier.size(width = 8.dp,height = 0.dp))

            Image(painter = painterResource(song.songUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)))

            Spacer(modifier = Modifier.size(width = 50.dp,height = 0.dp))

            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(80.dp)){
                Text(song.songName,color = Color(0xFF000000),fontSize = 24.sp, maxLines = 1)
                Text(song.singer,color = Color(0xB4000000))
            }

        }
    }
}

@Preview
@Composable
fun SongItemPreview(){
}