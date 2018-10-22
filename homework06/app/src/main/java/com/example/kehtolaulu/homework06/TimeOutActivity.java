package com.example.kehtolaulu.homework06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TimeOutActivity extends AppCompatActivity {

    TextView tvCongrats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_out);
        tvCongrats = findViewById(R.id.tv_time_out);
    }
}