package com.example.nav.test

import kotlinx.coroutines.*
class Test {


}

fun main(){
    GlobalScope.launch {
        delay(1000L)
        println("World")
    }

    println("Hello")

    Thread.sleep(2000)
}

