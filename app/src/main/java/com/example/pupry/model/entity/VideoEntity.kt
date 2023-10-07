package com.example.pupry.model.entity

import com.example.pupry.R

data class VideoEntity(

    val title : String = "",
    val type : String = "视频",
    var duration : String = "00:00:00",
    val ImageUrl : Int = R.raw.kiss

)