package com.example.test1launchmode;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import com.example.test1launchmode.databinding.ActivityCamera1Binding;

import java.util.Arrays;

/*
 *
 *
 * */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CameraActivity1 extends AppCompatActivity {

    private ActivityCamera1Binding binding;

    private CameraCaptureSession cameraCaptureSession;
    private CameraCaptureSession cameraCaptureSession1;
    private CameraDevice cameraDevice;
    private CameraDevice cameraDevice1;
    private Surface mPreviewSurface;
    private Surface mPreviewSurface1;

    CameraManager cameraManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera1);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera1);

        if (ActivityCompat.checkSelfPermission(CameraActivity1.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        } else {
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            initCamera();
        }
//        try {
//            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
//            Log.e("camera",cameraManager.getCameraIdList().toString());
//            for(String item:cameraManager.getCameraIdList()){
//                Log.e("camera---",item);
//                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(item);
//                Log.e("camera-----",characteristics.get(CameraCharacteristics.LENS_FACING)+"");
//            }
//        } catch (CameraAccessException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        initCamera();
    }

    public void initCamera() {
        binding.textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
                mPreviewSurface = new Surface(surface);

                try {
                    if (ActivityCompat.checkSelfPermission(CameraActivity1.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    //                    CameraCharacteristics.LENS_FACING_FRONT 0
//                    CameraCharacteristics.LENS_FACING_BACK 1

                    cameraManager.openCamera("0", new CameraDevice.StateCallback() {
                        @Override
                        public void onOpened(@NonNull CameraDevice camera) {
                            cameraDevice = camera;
                            try {
                                cameraDevice.createCaptureSession(Arrays.asList(mPreviewSurface), new CameraCaptureSession.StateCallback() {
                                    @RequiresApi(api = Build.VERSION_CODES.P)
                                    @Override
                                    public void onConfigured(@NonNull CameraCaptureSession session) {
                                        cameraCaptureSession = session;
                                        try {
                                            CaptureRequest.Builder builder;
                                            builder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
                                            builder.addTarget(mPreviewSurface);
                                            // repeating capture requests 重复捕获 收到一个连续的帧流
                                            cameraCaptureSession.setRepeatingRequest(builder.build(), null, null);

                                            //single capture requests
//                                            cameraCaptureSession.capture(builder.build(), null, null);

                                            //interleaving capturerequests
                                            //重复捕获请求处于活动状态时，发送第二个捕获请求， 预览时拍照，不需要停止正在重复的请求，发出一个非重复捕获请求，重复请求的优先级低于单帧请求
                                            //或突发请求
                                            //这样有一个跳帧的问题，需要添加输出目标

                                            //相机设备捕获的图像的请求
//                                            cameraCaptureSession.setSingleRepeatingRequest()
                                        } catch (Exception e) {
                                            Log.e("异常3", e.toString());
                                        }
                                    }

                                    @Override
                                    public void onConfigureFailed(@NonNull CameraCaptureSession session) {

                                    }
                                }, null);
                            } catch (Exception e) {
                                Log.e("异常2", e.toString());
                            }
                        }

                        @Override
                        public void onDisconnected(@NonNull CameraDevice camera) {
                            Log.e("异常211", "onDisconnected");
                        }

                        @Override
                        public void onError(@NonNull CameraDevice camera, int error) {

                        }
                    }, null);
                } catch (Exception e) {
                    Log.e("异常1", e.toString());
                } finally {

                }
            }

            @Override
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

            }
        });
//
        binding.textureView1.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
                mPreviewSurface1 = new Surface(surface);



                try {
                    if (ActivityCompat.checkSelfPermission(CameraActivity1.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
//                    CameraCharacteristics.LENS_FACING_FRONT 0
//                    CameraCharacteristics.LENS_FACING_BACK 1
                    cameraManager.openCamera("1", new CameraDevice.StateCallback() {
                        @Override
                        public void onOpened(@NonNull CameraDevice camera) {
                            cameraDevice1 = camera;
                            try {
                                cameraDevice1.createCaptureSession(Arrays.asList(mPreviewSurface1), new CameraCaptureSession.StateCallback() {
                                    @RequiresApi(api = Build.VERSION_CODES.P)
                                    @Override
                                    public void onConfigured(@NonNull CameraCaptureSession session) {
                                        cameraCaptureSession1 = session;
                                        try {
                                            CaptureRequest.Builder builder;
                                            builder = cameraDevice1.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
                                            builder.addTarget(mPreviewSurface1);
                                            // repeating capture requests 重复捕获 收到一个连续的帧流
                                            cameraCaptureSession1.setRepeatingRequest(builder.build(), null, null);

                                            //single capture requests
//                                            cameraCaptureSession.capture(builder.build(), null, null);

                                            //interleaving capturerequests
                                            //重复捕获请求处于活动状态时，发送第二个捕获请求， 预览时拍照，不需要停止正在重复的请求，发出一个非重复捕获请求，重复请求的优先级低于单帧请求
                                            //或突发请求
                                            //这样有一个跳帧的问题，需要添加输出目标

                                            //相机设备捕获的图像的请求
//                                            cameraCaptureSession.setSingleRepeatingRequest()
                                        } catch (Exception e) {
                                            Log.e("异常6", e.toString());
                                        }
                                    }

                                    @Override
                                    public void onConfigureFailed(@NonNull CameraCaptureSession session) {

                                    }
                                }, null);
                            } catch (Exception e) {
                                Log.e("异常5", e.toString());
                            }
                        }

                        @Override
                        public void onDisconnected(@NonNull CameraDevice camera) {

                        }

                        @Override
                        public void onError(@NonNull CameraDevice camera, int error) {

                        }
                    }, null);
                } catch (Exception e) {
                    Log.e("异常4", e.toString());
                } finally {

                }
            }

            @Override
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {

            }
        });
    }


}