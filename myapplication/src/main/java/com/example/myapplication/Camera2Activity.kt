package com.example.myapplication

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class Camera2Activity : AppCompatActivity() {

    private val cameraManager:CameraManager by lazy{
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            getSystemService(CameraManager::class.java)
        } else {
            TODO("VERSION.SDK_INT < M")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)
        Log.e("camera2---->","------------")
        val cameraList=cameraManager.cameraIdList
        Log.e("camera2---->",cameraList.size.toString())
        for( camera in cameraList ){
            Log.e("camera2---->",camera)
        }
//        cameraList.forEach { it->
//            val cameraCharacteristics=cameraManager.getCameraCharacteristics(it)
//            if (cameraCharacteristics.isHardwareLevelSupported(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_FULL)) {
//                if (cameraCharacteristics[CameraCharacteristics.LENS_FACING] == CameraCharacteristics.LENS_FACING_FRONT) {
//                    frontCameraId = cameraId
//                    frontCameraCharacteristics = cameraCharacteristics
//                } else if (cameraCharacteristics[CameraCharacteristics.LENS_FACING] == CameraCharacteristics.LENS_FACING_BACK) {
//                    backCameraId = cameraId
//                    backCameraCharacteristics = cameraCharacteristics
//                }
//            }
//        }
    }
}


