package com.example.kot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.net.URL
import java.util.*

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


        /*
        * async 用于在其他线程执行代码
        * uiThread回到主线程
        * uiThread依赖调用者，如果activity.isFinish()返回true，uiThread不会执行
        * 如果需要Future来工作，async返回一个Java future,如果您需要返回一一个future，使用asyncResult
        * */
        async {
            Request("https://www.baidu.com").run()
            uiThread {
                longToast("Request performed")
            }
        }


//        val f1=Forecast(Date(),27.5f,"Shine day")
//        val f2=f1.copy(temperature = 30f)

//        tv.setOnClickListener(View.OnClickListener { view -> var intent: Intent = Intent(MainActivity, MainActivity.class) })
        tv.setOnClickListener { toast("ceshi",Toast.LENGTH_SHORT) }


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
