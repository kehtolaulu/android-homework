package com.example.kehtolaulu.musicplayer

import android.content.SharedPreferences

interface Callback {
    fun callback(position: Int)

    fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String)
}