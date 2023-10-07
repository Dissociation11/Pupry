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
            Uri = "https://kvideo01.youju.sohu.com/5535742d-02e8-4080-ac7e-acbca64091ce2_0_0.mp4?sign=4a8c18b1052cca6b597b83c7daa873e5&t=1696683991",
            introduce = "本视频介绍了安卓开发"),
        VideoEntity(title = "视频1",
            ImageUri = "https://img0.baidu.com/it/u=2729488287,1197876823&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
            Uri = "https://703-11.vod.tv.itc.cn/sohu/v1/TmPmoAItWhcOZKEXDM8N8T9UepNCbT4MMS0GW8NR5m47fFoGRM1O0r.mp4?k=F4pKEp&p=jWlvzS13qSoi0S1Wj9lvzSwU0SsUqLPm0SPBomrAopvGopw3hRYAtUxIgYeiwm1BRMx4gGo70F2svmfCZMbVwm1mRexOfGbuRhdOfJdsZYoV0Y2svmN2ZMNB0p&r=TUldziJCtpCmhWlvsmCiopoWtWaizY&q=OpCmhW7IWJodRDvtvmfCyY2sRYvHZh6HfJ1X5G64WGo2ZDvXfJytRY6svm4cWJvsY&nid=703",
            introduce = ""),
        VideoEntity(title = "视频2",
            ImageUri = "https://lmg.jj20.com/up/allimg/1114/052221095508/210522095508-7-1200.jpg",
            Uri = "https://703-2.vod.tv.itc.cn/sohu/v1/TmoBTmPm0KIO0T16RYWsyTcLhAvt0E1m0Eo6hm6v5m47fFoGRM1O0r.mp4?k=b1U0Ir&p=jWlvzS1UoS1CopXWj9lvzSwU0SsUqLPm0SPBomrAopvGopw3hRYAtUxIgYeiwm1BRMx4gGo70F2svmfCZMbVwm1mRMKVf8n0SXBqLPG0EOUXpCmopwWjRxIymvBY&r=TUldziJCtpCmhWlvsmCiopoWtWaizY&q=OpC3hW7IWJodRDvtvmfCyY2sRYvHZh6HfJ1X5G64WGo2ZDvXfJytRY6svm4cWJbsr&nid=703",
            introduce = ""),
        VideoEntity(title = "视频3",
            ImageUri = "https://b.zol-img.com.cn/soft/5/181/ceXdIKfEcYH22.jpg",
            Uri = "https://703-3.vod.tv.itc.cn/sohu/v1/TmPAoKIOfJyHeh6BgA4A0KoefLEDPesVg84g8m63bFXUyYbSoO27fSx.mp4?k=knJrEK&p=jWlvzS13qSxUopvWj9lvzSwU0SsUqLkG0S1GqLwUqLXUqmrChRYAtUxIgYeiwm1BRMx4gGo70F2svmfCZMbVwm1mRexOfGbuRhyOWFA4ZhoV0Y2svmN2ZMNB0p&r=TUldziJCtpCmhWlvsmCiopoWtWaizY&q=OpCmhW7IWJodRDvtvmfCyY2sRYvHZh6HfJ1X5G64WGo2ZDvXfJytRY6Ovm4cWJW4r&nid=703",
            introduce = "https://img0.baidu.com/it/u=2729488287,1197876823&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500"),
        VideoEntity(title = "视频4",
            ImageUri = "https://img-baofun.zhhainiao.com/fs/7a9d05f13c34139e2910b21be71064f1.jpg",
            Uri = "https://703-8.vod.tv.itc.cn/sohu/v1/TmsGTmPC0KItN40MeOdgfAk2fM82qANsZ8ydy8dFlm47fFoGRM1O0r.mp4?k=OAkRQr&p=jWlvzSxU0SPmqpvmq6O349xIWhNXWGNtfJWXWJAOWYvsZh6sfheS0MocRYo70ScAZMx4gGo70O2CfMXS0pbcWhoGgY27oVfS0p0cWJoV0Y2svmN2ZM1mNp&r=TUldziJCtpCmhWlvsmCiopoWtWaizY&q=OpC3hW7IWJodRDvtvmfCyY2sRYvHZh6HfJ1X5G64WGo2ZDvXfJytRY6Ovm4cWJ6OY&nid=703",
            introduce = "https://img0.baidu.com/it/u=2729488287,1197876823&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500"),
        VideoEntity(title = "视频5",
            ImageUri = "https://imgs.aixifan.com/o_1cp6p00ol14tr10ftp0duro1ej598.jpg",
            Uri = "https://703-14.vod.tv.itc.cn/sohu/v1/TmwiTmPujWhAj3Oo4WJSSmll49vC9ZjPtpFPJ6BgXpxWsm3doRr.mp4?k=QAv9dK&p=jWlvzSxiopom0po7qKO349xIWhNXWGNtfJWXWJAOWYvsZh6sfheS0MocWh1sfYNS0pviNF2CfMXS0pWcgYeiwm12ZD6Sotxcyp0Gvm1mRDvS0m1cWhoV0F27oVp&r=TUldziJCtpCmhWlvsmCiopoWtWaizY&q=OpCAhW7IWJodRDvtvmfCyY2sRYvHZh6HfJ1X5G64WGo2ZDvXfJytRY6Ovm4cWJWOr&nid=703",
            introduce = "https://img0.baidu.com/it/u=2729488287,1197876823&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500"),
        VideoEntity(title = "视频6",
            ImageUri = "https://img0.baidu.com/it/u=1435639120,2241364006&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
            Uri = "https://703-14.vod.tv.itc.cn/sohu/v1/TmwiTmPujWhAj3Oo4WJSSmll49vC9ZjPtpFPJ6BgXpxWsm3doRr.mp4?k=QAv9dK&p=jWlvzSxiopom0po7qKO349xIWhNXWGNtfJWXWJAOWYvsZh6sfheS0MocWh1sfYNS0pviNF2CfMXS0pWcgYeiwm12ZD6Sotxcyp0Gvm1mRDvS0m1cWhoV0F27oVp&r=TUldziJCtpCmhWlvsmCiopoWtWaizY&q=OpCAhW7IWJodRDvtvmfCyY2sRYvHZh6HfJ1X5G64WGo2ZDvXfJytRY6Ovm4cWJWOr&nid=703",
            introduce = ""),
    )


}