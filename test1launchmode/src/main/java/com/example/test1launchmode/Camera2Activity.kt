package com.example.test1launchmode

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
/*Camera2

*CameraManager
 CameraCharacteristics 相机信息
 CaptureRequest 相机捕获图片的请求

*
* */
@RequiresApi(Build.VERSION_CODES.M)
class Camera2Activity : AppCompatActivity() {



    val TAG="Camera2"

    //获取CameraManager 延迟加载
    private val cameraManager: CameraManager by lazy{
        getSystemService(CameraManager::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)


//        Log.e(TAG,cameraManager.cameraIdList.size.toString());
//        var cameraList=cameraManager.cameraIdList
//        for(camera in cameraList){
//
//            var cameraCharacteristics:CameraCharacteristics=cameraManager.getCameraCharacteristics(camera)
//            Log.e(TAG,cameraCharacteristics.toString())
//        }

        var cameraCharacteristics=cameraManager.getCameraCharacteristics(Integer.toString(CameraCharacteristics.LENS_FACING_FRONT))
        var map=cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
        Log.e(TAG, map.toString())

    }
}