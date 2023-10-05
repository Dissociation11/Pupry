package com.example.pupry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pupry.model.entity.VideoEntity

class VideoViewModel : ViewModel() {

    var list = listOf(
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test"),
        VideoEntity("Test","Test","00:00:01","Test")
    )

}