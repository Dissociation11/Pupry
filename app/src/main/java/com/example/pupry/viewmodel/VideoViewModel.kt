package com.example.pupry.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.example.pupry.R
import com.example.pupry.model.entity.VideoEntity

class VideoViewModel : ViewModel() {


    var mediaPlayer: MediaPlayer? = null

    fun onCreate(context: Context){
        MediaPlayer.create(context, R.raw.kiss)
    }

    val list = listOf(
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1),
        VideoEntity("测试视频","视频","00:00:01",1)
    )


}