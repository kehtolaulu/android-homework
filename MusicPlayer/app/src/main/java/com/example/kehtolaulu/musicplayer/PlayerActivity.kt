package com.example.kehtolaulu.musicplayer

import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.ImageButton
import android.widget.TextView


class PlayerActivity : AppCompatActivity(), Callback, SharedPreferences.OnSharedPreferenceChangeListener, ServiceConnection {

    private lateinit var prev: ImageButton
    private lateinit var next: ImageButton
    private lateinit var play: ImageButton
    private lateinit var nameOfSong: TextView
    private var position: Int = 0
    private lateinit var musicPlayerService: MusicPlayerService
    private lateinit var playIntent: Intent
    private var songs = Playlist.songs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        prev = findViewById(R.id.btn_prev)
        next = findViewById(R.id.btn_next)
        play = findViewById(R.id.btn_play)
        nameOfSong = findViewById(R.id.tv_name)
        position = intent.getIntExtra("position", 0)

        prev.setOnClickListener {
            musicPlayerService.previous()
        }

        next.setOnClickListener {
            musicPlayerService.next()
        }

        play.setOnClickListener { musicPlayerService.play() }

        updatePlayingSong()
        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        prefs.registerOnSharedPreferenceChangeListener(this)
//        val intent = Intent(this, MusicPlayerService::class.java)
//        startService(intent)
//        bindService(intent, this, Context.BIND_AUTO_CREATE)
    }

    override fun onStart() {
        super.onStart()
        if (!::playIntent.isInitialized) {
            playIntent = Intent(this, MusicPlayerService::class.java)
            bindService(playIntent, this, Context.BIND_AUTO_CREATE)
            startService(playIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menu1 = menu.add(0, 1, 0, "Preferences")
        val intent = Intent(this, PreferenceActivity::class.java)
        menu1.intent = intent
        return super.onCreateOptionsMenu(menu)
    }

    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        val binder = service as MusicPlayerService.MusicBinder
        musicPlayerService = binder.service
        musicPlayerService.initMusicPlayer(this, songs, position)
    }

    override fun onServiceDisconnected(name: ComponentName) {
        unbindService(this)
    }

    override fun callback(position: Int) {
        this.position = position
        updatePlayingSong()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        recreate()
    }

    private fun updatePlayingSong() {
        nameOfSong.text = songs[position].name
    }

}
