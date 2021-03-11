package com.example.appkotlin

import android.annotation.SuppressLint
import android.app.Application
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setRefresh()
    }


    @SuppressLint("ResourceAsColor")
    fun setRefresh() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColors(R.color.colorPrimary, R.color.colorWhite)
            ClassicsHeader(context)
        })
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> ClassicsFooter(context) }
    }

}