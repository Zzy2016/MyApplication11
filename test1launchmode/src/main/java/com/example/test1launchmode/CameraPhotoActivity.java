package com.example.test1launchmode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.test1launchmode.databinding.ActivityCameraPhotoBinding;
//CameraDevice
//
public class CameraPhotoActivity extends AppCompatActivity {

    private ActivityCameraPhotoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera_photo);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera_photo);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String [] {Manifest.permission.CAMERA},1);
        }




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}