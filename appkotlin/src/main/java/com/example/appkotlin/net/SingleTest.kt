package com.example.appkotlin.net

import kotlin.math.sign


//object SingleTest {
//
//}


//class SingleTest private constructor() {
//    companion object {
//        private var instance: SingleTest? = null
//            get() {
//                if (field == null) {
//                    field = SingleTest()
//                }
//                return field
//            }
//
//
//        fun get(): SingleTest {
//            return instance!!
//        }
//    }
//}

//线程安全
//class SingleTest private constructor() {
//    companion object {
//        private var instance: SingleTest? = null
//            get() {
//                if (field == null) {
//                    field = SingleTest()
//                }
//                return field
//            }
//
//        @Synchronized
//        fun get(): SingleTest {
//            return instance!!
//        }
//    }
//}

//双重检验
//class SingleTest private constructor() {
//    companion object {
//        val instance: SingleTest by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            SingleTest()
//        }
//    }
//}


//静态内部
class SingleTest private constructor() {
    companion object {
        val instance = SingleTest
    }

    private object SingleTestHolder {
        val holder = SingleTest()
    }
}

fun main() {
//    SingleTest.get()

}