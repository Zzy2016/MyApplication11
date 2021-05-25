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
            //开始加载数据
            getBanner()
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
            getBanner()
        }
    }


    //获取banner
    fun getBanner() {

//        var source = "{\"data\":[{\"desc\":\"扔物线\",\"id\":29,\"imagePath\":\"https://wanandroid.com/blogimgs/8a0131ac-05b7-4b6c-a8d0-f438678834ba.png\",\"isVisible\":1,\"order\":0,\"title\":\"声明式 UI？Android 官方怒推的 Jetpack Compose 到底是什么？\",\"type\":0,\"url\":\"http://i0k.cn/4WyJG\"},{\"desc\":\"\",\"id\":6,\"imagePath\":\"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\"isVisible\":1,\"order\":1,\"title\":\"我们新增了一个常用导航Tab~\",\"type\":1,\"url\":\"https://www.wanandroid.com/navi\"},{\"desc\":\"一起来做个App吧\",\"id\":10,\"imagePath\":\"https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png\",\"isVisible\":1,\"order\":1,\"title\":\"一起来做个App吧\",\"type\":1,\"url\":\"https://www.wanandroid.com/blog/show/2\"},{\"desc\":\"\",\"id\":20,\"imagePath\":\"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png\",\"isVisible\":1,\"order\":2,\"title\":\"flutter 中文社区 \",\"type\":1,\"url\":\"https://flutter.cn/\"}],\"errorCode\":0,\"errorMsg\":\"\"}"
//        var gson = Gson()
//        var bannerModel = gson.fromJson(source, BannerBean::class.java)
//        mutableBanner.postValue(bannerModel)
//        loadState.postValue(LoadState.SUCCESS)
//        RetrofitManager.getService()
    }

    //获取文章
    fun getArticle() {

    }

    //获取另一种文章
    fun getArticle1() {

    }


}