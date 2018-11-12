package com.example.kehtolaulu.musicplayer

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object Themes {
    fun getTheme(context: Context): Int {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        val thisTheme = sp.getString("this", "current")
        var themeId = R.style.AppTheme
        when (thisTheme) {
            "1" -> themeId = R.style.green
            "2" -> themeId = R.style.red
            "3" -> themeId = R.style.white
        }
        return themeId
    }
}