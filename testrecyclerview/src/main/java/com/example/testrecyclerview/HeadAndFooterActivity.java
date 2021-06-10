package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.testrecyclerview.databinding.ActivityHeadAndFooterBinding;

public class HeadAndFooterActivity extends AppCompatActivity {


    ActivityHeadAndFooterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_head_and_footer);
//
        binding = DataBindingUtil.setContentView(this, R.layout.activity_head_and_footer);



    }

}