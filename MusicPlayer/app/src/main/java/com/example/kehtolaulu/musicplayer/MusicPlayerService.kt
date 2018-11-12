package com.example.kehtolaulu.musicplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.support.annotation.Nullable

class MusicPlayerService : Service() {
    private lateinit var songs: ArrayList<Song>
    private lateinit var mediaPlayer: MediaPlayer
    private var position: Int = 0
    private lateinit var callback: Callback
    private val musicBind = MusicBinder()

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
    }

    fun initMusicPlayer(callback: Callback, songs: ArrayList<Song>, position: Int) {
        this.callback = callback
        this.songs = songs
        this.position = position
        start()
    }

    private fun start() {
        mediaPlayer = MediaPlayer.create(this, songs[position].id)
//        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            next()
        }
    }

    @Nullable
    override fun onBind(intent: Intent): IBinder? {
        return musicBind
    }

    override fun onUnbind(intent: Intent): Boolean {
        mediaPlayer.stop()
        mediaPlayer.release()
        return false
    }

    internal inner class MusicBinder : Binder() {
        val service: MusicPlayerService
            get() = this@MusicPlayerService
    }

    fun next() {
        mediaPlayer.release()
        position++
        position = if (position == songs.size) 0 else position
        callback.callback(position)
        start()
    }

    fun previous() {
        mediaPlayer.release()
        position--
        position = if (position == -1) songs.size - 1 else position
        callback.callback(position)
        start()
    }

    fun play() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        } else {
            mediaPlayer.start()
        }
    }

    fun stop() {
        mediaPlayer.pause()
    }

    override fun onDestroy() {
        stopForeground(true)
    }

}