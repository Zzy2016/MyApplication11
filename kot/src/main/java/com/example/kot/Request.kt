package com.example.kot

import android.util.Log
import java.net.URL

class Request(val url:String) {
    public fun run(){
        val forecastStr=URL(url).readText();
        Log.e("123",forecastStr)
    }
}