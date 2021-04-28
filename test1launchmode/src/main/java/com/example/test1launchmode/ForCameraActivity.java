package com.example.test1launchmode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

/*
* 控制相机
*
* camera2
*
*
*
* */
public class ForCameraActivity extends AppCompatActivity {


    private CameraManager cameraManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_camera);

        cameraManager=getSystemService(CameraManager.class);

    }

}