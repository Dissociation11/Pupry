package com.example.pupry.compositionLocal

import androidx.compose.runtime.compositionLocalOf
import com.example.pupry.viewmodel.SongViewModel
import com.example.pupry.viewmodel.UserViewModel
import com.example.pupry.viewmodel.VideoViewModel

val LocalUserViewModel = compositionLocalOf<UserViewModel>{
    error("User View Model Content Not Found ")
}

val LocalSongViewModel = compositionLocalOf<SongViewModel>{
    error("User View Model Content Not Found ")
}

val LocalVideoViewModel = compositionLocalOf<VideoViewModel>{
    error("User View Model Content Not Found ")
}