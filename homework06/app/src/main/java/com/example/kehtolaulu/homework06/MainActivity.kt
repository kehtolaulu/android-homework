package com.example.kehtolaulu.homework06

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etTimeMin: EditText
    private lateinit var etTimeSec: EditText
    private lateinit var btnSet: Button
    private lateinit var btnCancel: Button
    private lateinit var tvLeft: TextView
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTimeMin = findViewById(R.id.et_min)
        etTimeSec = findViewById(R.id.et_sec)
        tvLeft = findViewById(R.id.tv_left)
        btnSet = findViewById(R.id.btn_set)
        btnCancel = findViewById(R.id.btn_cancel)

        btnCancel.setOnClickListener {
            cancelTimer()
            tvLeft.text = ""
        }

        btnSet.setOnClickListener { startTimer() }
    }

    private fun cancelTimer() {
        alarmManager.cancel(pendingIntent)
        Toast.makeText(this, "You've cancelled", Toast.LENGTH_LONG).show()
        timer.cancel()
    }

    private fun startTimer() {
        val timeOnTimer = (Integer.parseInt(etTimeMin.text.toString()) * 60000 + Integer.parseInt(etTimeSec.text.toString()) * 1000).toLong()
        startTimer(timeOnTimer)
        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intentTimer = Intent(this, AlertReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this, 555, intentTimer, PendingIntent.FLAG_CANCEL_CURRENT)
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeOnTimer, pendingIntent)
    }

    private fun startTimer(timeOnTimer: Long) {
        timer = object : CountDownTimer(timeOnTimer, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvLeft.text = "" + millisUntilFinished / 60000 + " minutes " + millisUntilFinished % 60000 / 1000 + " seconds left"
            }

            override fun onFinish() {
                Toast.makeText(applicationContext, "Time is out!", Toast.LENGTH_LONG)
                        .show()
            }
        }.start()
    }
}