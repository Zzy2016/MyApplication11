package com.example.testrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {


    RecyclerView rv;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rv = findViewById(R.id.rv);

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((i + 1) + "");
        }
        rv.setAdapter(new CommAdapter(list));
        rv.addItemDecoration(new SimpleItemDecoration(1));
    }


}