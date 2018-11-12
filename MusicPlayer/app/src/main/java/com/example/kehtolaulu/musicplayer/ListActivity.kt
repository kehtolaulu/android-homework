package com.example.kehtolaulu.musicplayer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu

class ListActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener, Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)
        val songAdapter = SongAdapter(SongListDiffCallback(), this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_songs)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = songAdapter
        songAdapter.submitList(Playlist.songs)

        PreferenceManager.setDefaultValues(this, R.xml.advanced_preferences, false)
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        val syncConnPref = sharedPref.getString(SettingsActivity.KEY_PREF_SYNC_CONN, "default")
        val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        prefs.registerOnSharedPreferenceChangeListener { prefs, key ->
            // listener implementation
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences,
                                           key: String) {
        if (key == KEY_PREF_SYNC_CONN) {
            val connectionPref = findPreference(key)
            connectionPref.setSummary(sharedPreferences.getString(key, ""))
        }
    }
    override fun callback(position: Int) {
        val intent = Intent(this, PlayerActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menu1 = menu.add(0, 1, 0, "Preferences")
        val intent = Intent(this, PreferenceActivity::class.java)
        menu1.intent = intent
        return super.onCreateOptionsMenu(menu)
    }

}
