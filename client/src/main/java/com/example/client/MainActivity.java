package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "android.intent.action.bind.gameservice";
                Intent intent = new Intent(action);
                intent.setPackage("com.smartwork.bindertest");
                bindService(intent, mServiceConnection, BIND_AUTO_CREATE);

            }
        });
    }
}