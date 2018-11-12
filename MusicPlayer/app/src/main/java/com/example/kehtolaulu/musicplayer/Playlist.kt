package com.example.kehtolaulu.musicplayer

class Playlist {
    companion object {
        var songs = arrayListOf(
                Song(R.raw.a, "Выше неба"),
                Song(R.raw.b, "Такая странная Москва"),
                Song(R.raw.c, "Bounce"),
                Song(R.raw.d, "Buffalo Bill"),
                Song(R.raw.e, "Озеро")
        )
    }
}
