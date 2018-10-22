package com.example.kehtolaulu.homework06

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat

class NotificationHelper {

    companion object {
        fun provideNotification(context: Context): Notification {
            val intentResult = Intent(context, TimeOutActivity::class.java)
            intentResult.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            val pendingIntent = PendingIntent.getActivity(context, 555, intentResult, PendingIntent.FLAG_CANCEL_CURRENT)
            val notificationBuilder = NotificationCompat.Builder(context, "5")
                    .setContentTitle("Hey!")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setContentText("Time is out!")
                    .setVisibility(Notification.VISIBILITY_PRIVATE)
                    .setContentIntent(pendingIntent)
            return notificationBuilder.build()
        }
    }
}