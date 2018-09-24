package com.example.kehtolaulu.homework_2018_09_17;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    TextView tvEmailEdit;
    TextView tvNameEdit;
    TextView tvNumberEdit;
    Button btnConfirm;
    Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        tvEmailEdit = findViewById(R.id.et_email_edit);
        tvNameEdit = findViewById(R.id.et_name_edit);
        tvNumberEdit = findViewById(R.id.et_phone_number_edit);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnCancel = findViewById(R.id.btn_cancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPost = new Intent();
                intentPost.putExtra("email", tvEmailEdit.getText().toString());
                intentPost.putExtra("name", tvNameEdit.getText().toString());
                intentPost.putExtra("number", tvNumberEdit.getText().toString());
                setResult(RESULT_OK, intentPost);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, cancelIntent);
                finish();
            }
        });

    }
}

