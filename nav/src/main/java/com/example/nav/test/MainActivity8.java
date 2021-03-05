package com.example.nav.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nav.R;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQueueManager.getInstance().pushActivity(this);
        setContentView(R.layout.activity_main8);

        Log.e("MainActivity-8", ActivityQueueManager.getInstance().getAll().toString());


        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActivityQueueManager.getInstance().doPopActivityByIndex(2);
                ActivityQueueManager.getInstance().pop();
                Log.e("MainActivity-8-1", ActivityQueueManager.getInstance().getAll().toString());

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityQueueManager.getInstance().popActivity(this);
    }
}