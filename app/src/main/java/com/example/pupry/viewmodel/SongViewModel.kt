package com.example.pupry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pupry.model.entity.SongEntity

class SongViewModel : ViewModel() {

    var list = listOf(
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
        SongEntity("Test","Test","Test"),
    )

}