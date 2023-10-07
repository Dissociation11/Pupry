package com.example.pupry.viewmodel

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pupry.R
import com.example.pupry.model.entity.SongEntity

class SongViewModel : ViewModel() {

    var mediaPlayer: MediaPlayer? = null

    var songInfo: SongEntity? = null

    fun addSong(index: Int) {
        songInfo = list[index]

    }

    @Composable
    fun onCreate(context: Context) {

        mediaPlayer = remember {
            MediaPlayer.create(context, songInfo!!.id)
        }

    }

    fun onStart() {
        mediaPlayer!!.start()
    }

    fun onPause() {
        mediaPlayer!!.pause()
    }

    fun onStop() {
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
        songInfo = null
    }

    var list = listOf(
        SongEntity(
            index = 0,
            id = R.raw.i_want_to_live,
            songName = "I Want To Live",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
        SongEntity(
            index = 1,
            id = R.raw.nightsong,
            songName = "Nightsong",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
        SongEntity(
            index = 2,
            id = R.raw.the_power_choral_version,
            songName = "The Power (Choral Version)",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
        SongEntity(
            index = 3,
            id = R.raw.the_power_orchestral_version,
            songName = "The Power (Orchestral Version)",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
        SongEntity(
            index = 4,
            id = R.raw.song_of_balduran,
            songName = "Song of Balduran",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
        SongEntity(
            index = 5,
            id = R.raw.raphaels_final_act,
            songName = "Raphael's Final Act",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
        SongEntity(
            index = 6,
            id = R.raw.down_by_the_river,
            songName = "Down By The River",
            singer = "Baldur's Gate 3 OST",
            songUrl = R.drawable.baldur_s_gate_3
        ),
    )

}