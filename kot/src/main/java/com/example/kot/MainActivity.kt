package com.example.kot

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        tv.text = "Main"
//
//
//        toast("hello")

        val forecastList = findViewById(R.id.rv) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        var list = listOf("Mon 6/23 - Sunny - 31/17",
                "Tue 6/24 - Foggy - 21/8",
                "Wed 6/25 - Cloudy - 22/17",
                "Thurs 6/26 - Rainy - 18/11",
                "Fri 6/27 - Foggy - 21/10",
                "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                "Sun 6/29 - Sunny - 20/7"
        )
        var adapter = ForeAdapter(list)
        forecastList.adapter = adapter



        async {

        }



    }

//    fun toast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
//        Toast.makeText(this, message, length);
//    }

    //拓展函数
    //在一个类上加上一种新的行为，
    fun Context.toast(message: String, length: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }




}
