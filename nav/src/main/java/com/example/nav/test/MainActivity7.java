package com.example.nav.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nav.R;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQueueManager.getInstance().pushActivity(this);
        setContentView(R.layout.activity_main7);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity7.this, MainActivity8.class);
                startActivity(intent);
            }
        });

        Log.e("MainActivity-7", ActivityQueueManager.getInstance().getAll().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityQueueManager.getInstance().popActivity(this);
    }
}