package com.example.myapplication11.ui.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseActivity;
import com.example.myapplication11.config.Constants;
import com.example.myapplication11.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {


    public static void start(Context context,Boolean isLogin){
        Intent intent=new Intent(context, MainActivity.class);
        intent.putExtra(Constants.ParamCode.PARAM1,isLogin);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
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