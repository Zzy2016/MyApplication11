package com.example.httptestj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.bumptech.glide.Glide;
import com.example.httptestj.databinding.ActivityMain4Binding;
import com.example.httptestj.databinding.ItemBinding;

public class MainActivity4 extends AppCompatActivity {

    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main4);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main4);

        String url="";
        Glide.with(getApplicationContext()).load("http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg").into(binding.img);

    }
}