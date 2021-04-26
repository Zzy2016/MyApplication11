package com.example.appkotlin.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appkotlin.R
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://wanandroid.com/banner/json
class TestActivity : AppCompatActivity() {

    var rootPath="https://wanandroid.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val retrofit=Retrofit.Builder().baseUrl(rootPath)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var service=retrofit.create(Api::class.java)
//        var call=service.getBanner()
//        call.enqueue(object:Callback<BannerModel>{
//            override fun onResponse(call: Call<BannerModel>, response: Response<BannerModel>) {
//
//                Log.e("success","success"+response.body().toString())
//            }
//
//            override fun onFailure(call: Call<BannerModel>, t: Throwable) {
//                Log.e("fail","fail")
//            }
//
//        })


//       GlobalScope.launch {
//           val result= withContext(Dispatchers.IO){
//               service.getBanner()
//           }
//           withContext(Dispatchers.Main){
//               tvResult.text= result.toString()
//           }
//           Log.e("banner", "$result")
//       }

//        runBlocking {
//            val result= withContext(Dispatchers.IO){
//                service.getBanner()
//            }
//            withContext(Dispatchers.Main){
//                tvResult.text = result.toString()
//            }
//            Log.e("banner","$result")
//        }





    }


}

