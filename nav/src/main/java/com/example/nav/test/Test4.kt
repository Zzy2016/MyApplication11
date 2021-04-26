package com.example.nav.test

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class Test4 {
}

//fun main(){
//    GlobalScope.launch {
//        delay(1000L)
//        println("World")
//    }
//
//    println("Hello")
//
//    Thread.sleep(2000)
//}

/*组合挂起函数
* 默认顺序调用
* 使用async并发
* 惰性启动的async
* async 风格的函数
* 使用async的结构化并发
* */
fun main()= runBlocking {
    var time= measureTimeMillis {
        val one= doSomeThingOne()
        val two= doSomeThingTwo()
        println("The answer is ${one+two}")

    }

    println("Complete  in $time")
}


suspend fun doSomeThingOne():Int{
    delay(1300)
    return 13
}

suspend fun doSomeThingTwo():Int{
    delay(1000)
    return 14
}