package com.example.appkotlin.activity.ui.home


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.example.appkotlin.LoadState
import com.example.appkotlin.base.BaseViewModel
import com.example.appkotlin.bean.BannerBean
import com.example.appkotlin.net.RetrofitManager
import com.example.appkotlin.utils.NetUtils
import com.google.gson.Gson
import java.util.concurrent.BlockingQueue

class HomeViewModel : BaseViewModel() {


    var mutableBanner: MutableLiveData<BannerBean> = MutableLiveData<BannerBean>()

    init {
        Log.e("banner-0", (mutableBanner == null).toString());
    }

    //页面初始加载数据
    override fun loadData() {
        if (!NetUtils.isConnect()) {
            loadState.postValue(LoadState.NO_NETWORK)
        } else {
            loadState.postValue(LoadState.LOADING)
            Log.e("LoadState--->B loading", "loadData: LoadState.LOADING)")
//            Thread.sleep(2000)
//            loadState.postValue(LoadState.SUCCESS)
//            Log.e("LoadState--->", "loadData: LoadState.SUCCESS)" )
            //开始加载数据

        }
    }

    //刷新数据
    override fun refreshData() {

    }

    //重新加载数据  网络异常 加载失败重新加载
    @RequiresApi(Build.VERSION_CODES.M)
    override fun reLoadData() {
        if (!NetUtils.isConnect()) {
            loadState.postValue(LoadState.NO_NETWORK)
        } else {
            //开始加载数据
//            RetrofitManager.getService().loadProjectTree()
        }
    }


    //获取文章
    fun getArticle() {

    }

    //获取另一种文章
    fun getArticle1() {

    }


}