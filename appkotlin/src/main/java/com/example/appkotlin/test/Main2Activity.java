package com.example.appkotlin.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.appkotlin.R;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SingleTest singleTest = SingleTest.getSingleTest();
        SingleTest singleTest1 = SingleTest.getSingleTest();

        Log.e("---------------", (singleTest == singleTest1)+"     "+singleTest.equals(singleTest1));


    }

}