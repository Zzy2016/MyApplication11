package com.example.httptestj;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.httptestj.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private MainActivity3ViewModel viewModel;
    private ActivityMain3Binding binding;

    private boolean isShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main3);


//        binding=ActivityMain3Binding.inflate(getLayoutInflater());
//
//        setContentView(binding.getRoot());


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        viewModel = new ViewModelProvider(this).get(MainActivity3ViewModel.class);
        binding.setViewModel(viewModel);


        ViewStub viewStub = findViewById(R.id.stub);

        binding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isShow = !isShow;
//                if (isShow) {
//                    inflated.setVisibility(View.VISIBLE);
//                } else {
//                    inflated.setVisibility(View.GONE);
//                }

                View inflated = viewStub.inflate();
            }
        });

        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                Log.e("-----", "viewStub-->");
            }
        });




//        ImageView imageView = findViewById(R.id.img);
//
//        Glide.with(MainActivity3.this).load("http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg").into(imageView);
//


    }


}