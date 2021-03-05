package com.example.nav.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.adapters.TextViewBindingAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nav.R;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQueueManager.getInstance().pushActivity(this);
        setContentView(R.layout.activity_main5);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(intent);
            }
        });

        Log.e("MainActivity-5", ActivityQueueManager.getInstance().getAll().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityQueueManager.getInstance().popActivity(this);
    }
}