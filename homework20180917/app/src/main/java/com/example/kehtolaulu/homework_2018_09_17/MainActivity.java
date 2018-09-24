package com.example.kehtolaulu.homework_2018_09_17;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ID = 1;
    private static final int REQUEST = 0;

    TextView tvEmail;
    TextView tvName;
    TextView tvPhoneNumber;
    Button btnEdit;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmail = findViewById(R.id.tv_email);
        tvName = findViewById(R.id.tv_name);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        btnEdit = findViewById(R.id.btn_edit);
        btnSend = findViewById(R.id.btn_send);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, REQUEST);
            }
        });


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String send = tvName.getText().toString();
                Intent intentSend = new Intent(Intent.ACTION_SEND);
                intentSend.putExtra(Intent.EXTRA_TEXT, send);
                intentSend.setType("text/plain");
                startActivityForResult(intentSend, REQUEST_ID);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "You have cancelled", Toast.LENGTH_LONG).show();
            }
            String filledEmail = data.getStringExtra("email");
            String filledName = data.getStringExtra("name");
            String filledNumber = data.getStringExtra("number");

            tvEmail.setText(filledEmail);
            tvName.setText(filledName);
            tvPhoneNumber.setText(filledNumber);
        }
    }
}

