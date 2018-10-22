package com.example.kehtolaulu.homework06

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class TimeOutActivity : AppCompatActivity() {

    private lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_out)
        tvTime = findViewById(R.id.tv_time_out)
    }
}