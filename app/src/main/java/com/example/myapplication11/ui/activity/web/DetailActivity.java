package com.example.myapplication11.ui.activity.web;

import android.os.Bundle;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseActivity;
import com.example.myapplication11.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity<ActivityDetailBinding,DetailViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected void init() {

    }
}