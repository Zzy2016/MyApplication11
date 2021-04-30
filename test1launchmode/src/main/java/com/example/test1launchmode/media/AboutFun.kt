package com.example.test1launchmode.media



/*
* let
* run
* with
* apply
* also
*
* 引入上下文对象的方式
* 返回值
* */
fun main(){
    var str="hello"
    str.run {
        println("The receiver string length : $length")
    }
}