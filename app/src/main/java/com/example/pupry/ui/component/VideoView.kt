package com.example.pupry.ui.component

import android.view.LayoutInflater
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.example.pupry.R
import com.tencent.rtmp.TXVodPlayer
import com.tencent.rtmp.ui.TXCloudVideoView

@Composable
fun VideoView(vodPlayer : TXVodPlayer){

    AndroidView(factory = {content ->
        (LayoutInflater.from(content).inflate(R.layout.video,null,false)
            .findViewById(R.id.videoview) as TXCloudVideoView).apply{
            vodPlayer.setPlayerView(this)
        }
    })

}