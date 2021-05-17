package com.example.mediatest


import android.content.Intent
import android.hardware.Camera
import android.media.CamcorderProfile
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.SurfaceHolder
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_media_recorder.*
import java.io.File
import java.nio.channels.DatagramChannel.open
import java.nio.channels.Pipe.open

class MediaRecorderActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private val videoRecorderFile: String

    init {
        val fileDir = File("${Environment.getExternalStorageDirectory().absoluteFile}/test")
        fileDir.mkdirs()
        videoRecorderFile = "$fileDir/video_record.mp4"
    }

    private var camera: Camera? = null

    private var isRecording = false

    private var mediaRecorder: MediaRecorder? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_recorder)


        surface.holder.addCallback(this)

        video_record.setOnClickListener {
            if (isRecording) {
                stopVideoRecord()
            } else {
                startVideoRecord()
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun surfaceCreated(holder: SurfaceHolder) {
        if (camera == null) {
            camera = Camera.open()
        }

        camera!!.enableShutterSound(false)
        camera!!.setDisplayOrientation(90)
        camera!!.setPreviewDisplay(holder)
        camera!!.startPreview()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        if(holder.surface==null){
            return
        }
        camera!!.stopPreview()
        camera!!.setPreviewDisplay(holder)
        camera!!.startPreview()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

    private fun startVideoRecord() {
        mediaRecorder=MediaRecorder().apply {
            camera!!.unlock()
            setCamera(camera!!)
            setOrientationHint(90)
            setAudioSource(MediaRecorder.AudioSource.CAMCORDER)
            setVideoSource(MediaRecorder.VideoSource.CAMERA)

            setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH))
            setOutputFile(videoRecorderFile)
//            setPreviewDisplay(surface.holder.surface)
            prepare()
            start()
        }
        isRecording=true
        video_record.text="停止录制"
    }

    private fun stopVideoRecord() {
        mediaRecorder?.let {
            it.stop()
            it.release()
            mediaRecorder=null
        }
        camera!!.lock()
        isRecording=false
        video_record.text="kaishi"
        startActivity(Intent(this,MediaPlayerActivity::class.java))
    }

}


