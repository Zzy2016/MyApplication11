package com.example.test1launchmode.sounds

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.media.MediaBrowserServiceCompat

/*
* 声音播放服务
* 这里应该是一个控制会话
* */

private const val MY_MEDIA_ROOT_ID = "meida_root_id"
private const val MY_EMPTY_MEDIA_ROOT_ID = "empty_root_id"

class MediaPlaybackService : MediaBrowserServiceCompat() {

    private var mediaSession: MediaSessionCompat? = null
    private lateinit var stateBuilder: PlaybackStateCompat.Builder
    private var TAG = "Sounds--"

    override fun onCreate() {
        super.onCreate()
        mediaSession = MediaSessionCompat(baseContext, TAG).apply {
            setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS or MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS)
            stateBuilder = PlaybackStateCompat.Builder().setActions(PlaybackStateCompat.ACTION_PLAY or PlaybackStateCompat.ACTION_PLAY_PAUSE)
            setPlaybackState(stateBuilder.build())
            setCallback()
            setSessionToken(mediaSession)
        }

    }

    override fun onGetRoot(clientPackageName: String, clientUid: Int, rootHints: Bundle?): BrowserRoot? {

    }

    override fun onLoadChildren(parentId: String, result: Result<MutableList<MediaBrowserCompat.MediaItem>>) {

    }
}