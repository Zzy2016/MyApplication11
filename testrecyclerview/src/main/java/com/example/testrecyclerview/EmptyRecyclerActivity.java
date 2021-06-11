package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmptyRecyclerActivity extends AppCompatActivity {


    EmptyRecyclerView emptyRecyclerView;
    List<String> list;
    TextView tvEmpty;
    TextView tvClear;
    CommAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_recycler);
        emptyRecyclerView = findViewById(R.id.rv);
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + "");
        }
        adapter = new CommAdapter(list);
        tvEmpty = findViewById(R.id.tvEmpty);
        emptyRecyclerView.setEmptyView(tvEmpty);
        emptyRecyclerView.setAdapter(adapter);
        emptyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tvClear = findViewById(R.id.tvClear);
        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                adapter.notifyDataSetChanged();
            }
        });

    }
}