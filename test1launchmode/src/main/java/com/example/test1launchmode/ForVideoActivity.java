package com.example.test1launchmode;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class ForVideoActivity extends AppCompatActivity {



    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_video);
        mediaController=new MediaController(this);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent,1);
                }
            }
        });

        videoView=findViewById(R.id.videoView);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });



        videoView.setMediaController(mediaController);


//        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaController.show();
//            }
//        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==-1&&requestCode==1){
            Log.e("Uri",data.getData()+"");
            videoView.setVideoURI(data.getData());
//            videoView.setBackground();
            Drawable drawable=new BitmapDrawable(getVideoBitmap(data.getData()));
            videoView.setForeground(drawable);
        }
    }


    private Bitmap getVideoBitmap(Uri uri){
        MediaMetadataRetriever retriever=null;
        try{
            retriever=new MediaMetadataRetriever();
            retriever.setDataSource(this,uri);
            Bitmap bitmap=retriever.getFrameAtTime();
            return bitmap;
        }finally {
            retriever.release();
        }

    }
}