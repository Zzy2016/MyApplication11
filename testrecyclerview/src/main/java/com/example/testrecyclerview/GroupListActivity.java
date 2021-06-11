package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupListActivity extends AppCompatActivity {

    RecyclerView rv;
    List<String> list;
    String[] array = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int length = new Random().nextInt(10);
            for (int j = 0; j < 5; j++) {
                list.add(array[i] + "" + j);
            }

        }
        rv = findViewById(R.id.rv);
        rv.setAdapter(new CommAdapter(list));
        rv.addItemDecoration(new SectionDecoration(list));
    }
}