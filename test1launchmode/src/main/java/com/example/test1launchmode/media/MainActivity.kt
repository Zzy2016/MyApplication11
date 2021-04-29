package com.example.test1launchmode.media

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import com.example.test1launchmode.R

/*
* 播放器 吸收数字媒体并将其呈现为视频或音频
* 界面   带有用于运行播放器并显示播放器状态的传输控件
*
* 使用与标准播放器操作相对应的预定义回调，以及用于定义应用独有的特殊行为的可拓展自定义调用
*
* 媒体会话
* 媒体会话负责与播放器的所有的通信，系统只能从控制播放器的媒体会话中调用播放器。
* 会话会维护播放器状态的表示形式以及播放内容的相关信息。并且可以接受来一个或多个媒体控制器的回调。
* 响应回调的逻辑必须保持一致。无论哪个客户端应用发起了回调，对MediaSession回调的相应都应该相同
* 媒体控制器
* 媒体控制器会隔离界面。您的界面代码只能与媒体控制器通信。媒体控制器会将传输控制操作转换为对媒体会话的回调。
* 会话状态发生变化时，它也会接受来自媒体会话的回调。媒体控制器一次只能链接一个媒体会话。
*
*
*
* 视频应用需要一个窗口来查看内容，通常用单个Activity
* 音频不总是需要显示界面，一旦开始播放音频，播放器可以作为后台任务，Activity(界面) + Service(播放器)**
*
*
*
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)



    }
}