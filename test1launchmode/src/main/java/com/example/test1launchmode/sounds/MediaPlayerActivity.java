package com.example.test1launchmode.sounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import com.example.test1launchmode.R;

public class MediaPlayerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);



    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onStop() {
        super.onStop();

    }


//    public final MediaBrowserCompat.ConnectionCallback connectionCallback = new MediaBrowserCompat.ConnectionCallback() {
//        @Override
//        public void onConnected() {
//            MediaSessionCompat.Token token = mediaBrowser.getSessionToken();
//            try {
//                MediaControllerCompat mediaController = new MediaControllerCompat(MediaPlayerActivity.this, token);
//                MediaControllerCompat.setMediaController(MediaPlayerActivity.this, mediaController);
//
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        public void onConnectionSuspended() {
//
//        }
//
//        @Override
//        public void onConnectionFailed() {
//
//        }
//    };
//
//    void buildTransportControls() {
//        int pbState = MediaControllerCompat.getMediaController(MediaPlayerActivity.this).getPlaybackState().getState();
//        if (pbState == PlaybackStateCompat.STATE_PLAYING) {
//            MediaControllerCompat.getMediaController(MediaPlayerActivity.this).getTransportControls().pause();
//        } else {
//            MediaControllerCompat.getMediaController(MediaPlayerActivity.this).getTransportControls().play();
//        }
//
//        MediaControllerCompat mediaController = MediaControllerCompat.getMediaController(MediaPlayerActivity.this);
//
//
//    }

}