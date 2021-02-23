package com.example.httptestj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.httptestj.databinding.ActivityMain5Binding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    private ActivityMain5Binding binding;

    private List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main5);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main5);

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("name" + i);
            user.setBlog("blog" + i);
            list.add(user);
        }

        ItemAdapter itemAdapter = new ItemAdapter(list);
        binding.rvList.setAdapter(itemAdapter);


        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();
                user.setId(String.valueOf(list.size()));
                user.setBlog("blog"+list.size());
                user.setName("name"+list.size());
                list.add(user);
                itemAdapter.notifyDataSetChanged();
                binding.rvList.scrollToPosition(list.size()-1);
            }
        });

    }
}