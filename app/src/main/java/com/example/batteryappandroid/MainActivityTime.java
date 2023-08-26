package com.example.batteryappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityTime extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time);
        Intent intent = getIntent();
        String resultText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(resultText);
    }


}