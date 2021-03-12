package com.example.appkotlin

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator
import kotlin.properties.Delegates

class MyApplication : Application() {


    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        setRefresh()
        CONTEXT = applicationContext
    }

//    @JvmName("getContext1")
//    fun getContext(): Context {
//        return context
//    }


    @SuppressLint("ResourceAsColor")
    fun setRefresh() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColors(R.color.colorPrimary, R.color.colorWhite)
            ClassicsHeader(context)
        })
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> ClassicsFooter(context) }
    }



}