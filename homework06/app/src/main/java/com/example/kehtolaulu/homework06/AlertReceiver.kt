package com.example.kehtolaulu.homework06

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager

class AlertReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val channelId = "5"
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, "channel1", importance)
            notificationManager.createNotificationChannel(channel)
            channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), channel.audioAttributes)
        }
        notificationManager.notify(1, NotificationHelper.provideNotification(context))
    }
}