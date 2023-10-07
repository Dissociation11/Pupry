package com.example.pupry.viewmodel

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.util.Util
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import com.example.pupry.R
import com.example.pupry.model.entity.VideoEntity

class VideoViewModel : ViewModel() {

    var exoPlayer : ExoPlayer? = null


    var videoInfo : VideoEntity? = null

    fun addVideo(video:VideoEntity){
        videoInfo = video
    }

    fun onStop(){
        exoPlayer!!.stop()
        videoInfo = null
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun  onCreate(context: Context){

        var mediaItem = MediaItem.fromUri(Uri.parse(if(videoInfo != null ) videoInfo!!.Uri else ""))

         exoPlayer = ExoPlayer.Builder(context).build().apply {
            var dataSourceFactory : DataSource.Factory = DefaultDataSourceFactory(context,
                Util.getUserAgent(context,context.packageName))

            val source = ProgressiveMediaSource
                .Factory(dataSourceFactory)
                .createMediaSource(mediaItem)

            this.prepare(source)
        }

    }

    val list = listOf(
        VideoEntity(title = "安卓开发介绍",
            ImageUri = "https://img1.baidu.com/it/u=2080801041,3349735074&fm=253&fmt=auto&app=120&f=JPEG?w=1139&h=640",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = "本视频介绍了安卓开发"),
        VideoEntity(title = "视频1",
            ImageUri = "https://img0.baidu.com/it/u=2729488287,1197876823&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = ""),
        VideoEntity(title = "视频2",
            ImageUri = "https://lmg.jj20.com/up/allimg/1114/052221095508/210522095508-7-1200.jpg",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = ""),
        VideoEntity(title = "视频3",
            ImageUri = "https://b.zol-img.com.cn/soft/5/181/ceXdIKfEcYH22.jpg",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = ""),
        VideoEntity(title = "视频4",
            ImageUri = "https://img-baofun.zhhainiao.com/fs/7a9d05f13c34139e2910b21be71064f1.jpg",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = ""),
        VideoEntity(title = "视频5",
            ImageUri = "https://imgs.aixifan.com/o_1cp6p00ol14tr10ftp0duro1ej598.jpg",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = ""),
        VideoEntity(title = "视频6",
            ImageUri = "https://img0.baidu.com/it/u=1435639120,2241364006&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=e8510ede58481a205ac45a3ae768641e&t=1696710861",
            introduce = ""),
    )


}