package com.example.pupry.ui.screen

import android.media.MediaPlayer
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.common.util.Util
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.example.pupry.R
import com.example.pupry.compositionLocal.LocalVideoViewModel
import com.example.pupry.ui.component.TopAppBar
import com.example.pupry.ui.component.VideoDescrtionBackground

@Composable
@OptIn(UnstableApi::class)
fun VideoScreen(onBack:()->Unit = {}) {

    val content = LocalContext.current
    val videoViewModel = LocalVideoViewModel.current
    var isStop by remember {
        mutableStateOf(false)
    }

    videoViewModel.onCreate(content)

    Column() {

        TopAppBar(topAppBarHeight = 40.dp) {

            Icon(imageVector = Icons.Default.ArrowBack, "",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(24.dp)
                    .align(Alignment.CenterStart)
                    .clickable {
                        isStop = true
                        onBack.invoke()
                    })

            Text(
                "视频",
                modifier = Modifier.align(Alignment.Center),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }

        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier
                .fillMaxWidth()) {

                AndroidView(factory = {context ->
                    PlayerView(context).apply {
                        player = videoViewModel.exoPlayer
                    }
                })

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(VideoDescrtionBackground)
            ) {

                item {
                    Text(
                        text = if(videoViewModel.videoInfo != null) videoViewModel.videoInfo!!.title else "信息错误",
                        color = Color(0xFF0F0F0F),
                        fontSize = 24.sp
                    )
                }

                item {

                    Divider()

                    Text(
                        "简介:",
                        fontSize = 18.sp
                    )

                }

                item {
                    Text(if (videoViewModel.videoInfo != null)videoViewModel.videoInfo!!.introduce else "信息获取失败")
                }

            }

        }

    }

}


@Preview
@Composable
fun VideoScreenPreview(){
    VideoScreen()
}