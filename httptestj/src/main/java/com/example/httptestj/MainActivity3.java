package com.example.httptestj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.httptestj.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private MainActivity3ViewModel viewModel;
    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        viewModel = new ViewModelProvider(this).get(MainActivity3ViewModel.class);
        binding.setViewModel(viewModel);
    }



}