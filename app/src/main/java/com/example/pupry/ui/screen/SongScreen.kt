package com.example.pupry.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.NotStarted
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pupry.compositionLocal.LocalSongViewModel
import com.example.pupry.model.entity.SongEntity
import com.example.pupry.ui.component.FirstColor
import com.example.pupry.ui.component.LastColor
import com.example.pupry.ui.component.TopAppBar
import com.mysql.jdbc.Util.getPackageName

@Composable
fun SongScreen(onBack:()->Unit = {}){

    val songViewModel = LocalSongViewModel.current
    val context = LocalContext.current

    var isPlaying by remember{
        mutableStateOf(true)
    }

    songViewModel.onCreate(context)

    LaunchedEffect(true){
        songViewModel.onStart()
    }

    Column(){

        TopAppBar(topAppBarHeight = 60.dp){

            Icon(imageVector = Icons.Default.ArrowBack,"",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(24.dp)
                    .align(Alignment.CenterStart)
                    .clickable { onBack.invoke() })

            Text(text = if(songViewModel.songInfo != null)songViewModel.songInfo!!.songName else "歌名信息错误",
                modifier = Modifier.align(Alignment.Center),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)

        }

        Box(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxSize().padding(bottom = 80.dp)) {

                Image(painter = painterResource(id = com.example.pupry.R.drawable.seville),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())

                Text(text = "暂无歌词..",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )

            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.linearGradient(
                            listOf(FirstColor, LastColor)
                        )
                    )
            ) {

                Spacer(modifier = Modifier.size(0.dp))

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp).clickable {
                        Toast.makeText(context,"无法正常切换到上一首歌曲",Toast.LENGTH_SHORT).show()
                    }
                )

                Icon(imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.NotStarted,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp).clickable {
                        if (isPlaying) {
                            songViewModel.onPause()
                            isPlaying = false
                        } else {
                            songViewModel.onStart()
                            isPlaying = true
                        }
                    }
                )

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp).clickable {
                        Toast.makeText(context,"无法正常切换到下一首歌曲",Toast.LENGTH_SHORT).show()
                    }
                )

                Spacer(modifier = Modifier.size(0.dp))

            }

        }

    }

}

@Preview
@Composable
fun SongScreenPreview(){
    SongScreen()
}