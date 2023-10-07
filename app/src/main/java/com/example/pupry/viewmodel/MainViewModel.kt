package com.example.pupry.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pupry.model.entity.ContentType
import com.example.pupry.model.entity.SongEntity
import com.example.pupry.model.entity.SwiperEntity


class MainViewModel : ViewModel() {

    var contentType = mutableStateOf(listOf(
        ContentType("歌曲"),
        ContentType("视频")
    ))

    var selectedType by mutableStateOf(0)

    var swiperData = listOf(
        SwiperEntity("https://img2.baidu.com/it/u=861863691,2776527252&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500"),
        SwiperEntity("https://img0.baidu.com/it/u=1049144354,3589714554&fm=253&fmt=auto&app=120&f=JPEG?w=1280&h=800"),
        SwiperEntity("https://img2.baidu.com/it/u=3219906533,2982923681&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500"),
        SwiperEntity("https://imgs.aixifan.com/o_1cp6p00ol13ubbtto6fhno1c3n8j.jpg")
    )
}