package com.example.nav

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity5 : AppCompatActivity() {


    private val mainScope= MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)


//        runBlocking {  }
//        withContext()
//        withTimeout()
//        launch
//        async
//        Dispatchers  调度
//        CoroutineScope  作用域 它会创建一个协程作用域并且在所有已启动子协程执行完毕之前不会结束。
//        CoroutineContext  上下文
//        suspend  挂起函数  某些时刻挂起和恢复


    }







    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }


}