package com.example.test1launchmode

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.ImageFormat
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CameraMetadata
import android.media.ImageReader
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.TextureView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_camera2.*

/*Camera2

*CameraManager
 CameraCharacteristics 相机信息
 CaptureRequest 相机捕获图片的请求

*
* */
@RequiresApi(Build.VERSION_CODES.M)
class Camera2Activity : AppCompatActivity() {


    val TAG = "Camera2"

    //获取CameraManager 延迟加载
    private val cameraManager: CameraManager by lazy {
        getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)


        val imageReader = ImageReader.newInstance(300, 300, ImageFormat.JPEG, 400)
        val preViewSurfaceView = surfaceView.holder.surface
        val imReaderSurface = imageReader.surface
        var targets = listOf(preViewSurfaceView, imReaderSurface)


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            return
        }



    }


}




