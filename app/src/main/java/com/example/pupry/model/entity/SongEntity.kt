package com.example.pupry.model.entity

import com.example.pupry.R


data class SongEntity(
    val index : Int = 0,
    val id: Int = R.raw.i_want_to_live,//歌曲路径
    val songName: String = "", //歌曲名称
    val singer: String = "", //歌手名称
    val duration: String = "", //歌曲时长
    val songUrl: Int = R.drawable.redprince,//歌曲图片
)