package com.example.test1launchmode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;

import com.example.test1launchmode.databinding.ActivityCamera3Binding;

public class Camera3Activity extends AppCompatActivity {

    private ActivityCamera3Binding binding;
    Camera2Provider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera3);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera3);
        provider = new Camera2Provider(this);
        provider.initTexture(binding.textureView);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStop() {
        super.onStop();
        provider.closeCamera();
    }
}