package com.example.aboutresult;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//https://wanandroid.com/ banner/json
//
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RetrofitHelper.getInstance().create().getVideoList().enqueue();
    }
}